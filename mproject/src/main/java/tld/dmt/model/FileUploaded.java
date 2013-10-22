package tld.dmt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: ejolos
 * Date: 10/21/13
 */
@Entity
@Table(name="FILE_UPLOADED")
@SuppressWarnings("serial")
public class FileUploaded implements Serializable {

    private Integer id;
    private String filename;
    private Integer filesize;
    private Date updated;

    @Id
    @Column( name = "id", updatable = false, nullable = false )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
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
