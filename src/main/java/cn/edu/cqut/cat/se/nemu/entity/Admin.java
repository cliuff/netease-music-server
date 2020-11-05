package cn.edu.cqut.cat.se.nemu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
