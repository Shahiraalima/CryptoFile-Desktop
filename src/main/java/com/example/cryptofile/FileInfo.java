package com.example.cryptofile;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class FileInfo {
    private int file_id;
    private int user_id;

    private String og_file_name;
    private Long og_file_size;
    private String og_file_type;
    private String og_file_hash;

    private String encrypted_file_name;
    private Long encrypted_file_size;
    private String encrypted_file_hash;


    private String status;
    private LocalDateTime encrypted_at;
    private LocalDateTime decrypted_at;


    private Boolean deleted;

    public FileInfo() {
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOg_file_name() {
        return og_file_name;
    }

    public void setOg_file_name(String og_file_name) {
        this.og_file_name = og_file_name;
    }


    public Long getOg_file_size() {
        return og_file_size;
    }

    public void setOg_file_size(Long og_file_size) {
        this.og_file_size = og_file_size;
    }

    public String getOg_file_type() {
        return og_file_type;
    }

    public void setOg_file_type(String og_file_type) {
        this.og_file_type = og_file_type;
    }

    public String getEncrypted_file_name() {
        return encrypted_file_name;
    }

    public void setEncrypted_file_name(String encrypted_file_name) {
        this.encrypted_file_name = encrypted_file_name;
    }

    public Long getEncrypted_file_size() {
        return encrypted_file_size;
    }

    public void setEncrypted_file_size(Long encrypted_file_size) {
        this.encrypted_file_size = encrypted_file_size;
    }

    public String getOg_file_hash() {
        return og_file_hash;
    }

    public void setOg_file_hash(String og_file_hash) {
        this.og_file_hash = og_file_hash;
    }

    public String getEncrypted_file_hash() {
        return encrypted_file_hash;
    }

    public void setEncrypted_file_hash(String encrypted_file_hash) {
        this.encrypted_file_hash = encrypted_file_hash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEncrypted_at() {
        return encrypted_at;
    }

    public void setEncrypted_at(LocalDateTime encrypted_at) {
        this.encrypted_at = encrypted_at;
    }

    public LocalDateTime getDecrypted_at() {
        return decrypted_at;
    }

    public void setDecrypted_at(LocalDateTime decrypted_at) {
        this.decrypted_at = decrypted_at;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
