package tld.dmt.model;

import org.hibernate.annotations.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * User: ejolos
 * Date: 10/21/13
 */

@Entity
@Table(name="FILE_UPLOADED")
public class FileUploaded implements Serializable {

    private Integer id;
    private String filename;
    private Integer filesize;
    private Date updated;

    @Id
    @Column (name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column (name="filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Column (name="filesize")
    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    @Column (name="updated_on")
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
