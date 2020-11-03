package cn.edu.cqut.cat.se.nemu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-03
 */
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    private String adminId;

    private String adminName;

    private String password;

    private LocalDateTime time;


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    protected Serializable pkVal() {
        return this.adminId;
    }

    @Override
    public String toString() {
        return "Admin{" +
        "adminId=" + adminId +
        ", adminName=" + adminName +
        ", password=" + password +
        ", time=" + time +
        "}";
    }
}
