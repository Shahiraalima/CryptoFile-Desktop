package com.example.cryptofile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FileDAO {

    public FileDAO() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            System.out.print("Connected to database successfully");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }

    public void insertFile(FileInfo fileInfo) {
        String query = "INSERT INTO files " +
                "(user_id, og_file_name, og_file_path, og_file_size, og_file_type, " +
                "encrypted_file_name, encrypted_file_path, encrypted_file_size, encrypted_at, decrypted_at)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), NULL)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, fileInfo.getUser_id());
            statement.setString(2, fileInfo.getOg_file_name());
            statement.setString(3, fileInfo.getOg_file_path());
            statement.setLong(4, fileInfo.getOg_file_size());
            statement.setString(5, fileInfo.getOg_file_type());
            statement.setString(6, fileInfo.getEncrypted_file_name());
            statement.setString(7, fileInfo.getEncrypted_file_path());
            statement.setLong(8, fileInfo.getEncrypted_file_size());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new encrypted file record was inserted successfully!");
            } else {
                System.out.println("Failed to insert the encrypted file record.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateForRe_encryption(FileInfo fileInfo) {
        String query = "UPDATE files SET encrypted_file_name = ?, encrypted_file_path = ?, " +
                "encrypted_file_size = ?, status = 'encrypted', encrypted_at = NOW(), decrypted_at = NULL WHERE og_file_path = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, fileInfo.getEncrypted_file_name());
            statement.setString(2, fileInfo.getEncrypted_file_path());
            statement.setLong(3, fileInfo.getEncrypted_file_size());
            statement.setString(4, fileInfo.getOg_file_path());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("The file record was updated successfully for re-encryption!");
            } else {
                System.out.println("Failed to update the file record for re-encryption.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean checkFileExists(String og_file_path) {
        String query = "SELECT status FROM files WHERE og_file_path = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, og_file_path);

            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                String isEncrypted = rs.getString("status");
                return isEncrypted.equals("encrypted");
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
