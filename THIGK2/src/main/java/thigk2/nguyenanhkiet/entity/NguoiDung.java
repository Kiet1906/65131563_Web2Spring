package thigk2.nguyenanhkiet.entity;

import jakarta.persistence.*;

@Entity
public class NguoiDung {
    @Id
    private String username;
    private String password;
    private String hoTen;

    public NguoiDung() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
}