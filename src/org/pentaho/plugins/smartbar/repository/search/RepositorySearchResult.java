package org.pentaho.plugins.smartbar.repository.search;

import java.util.Date;

/**
 * Created by PeterF on 4/26/2014.
 */
public class RepositorySearchResult {
    private String name;
    private String id;
    private String type;
    private Date lastModified;
    private String owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
