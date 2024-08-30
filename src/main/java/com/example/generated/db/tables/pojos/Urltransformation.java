/*
 * This file is generated by jOOQ.
 */
package com.example.generated.db.tables.pojos;


import com.example.generated.db.tables.interfaces.IUrltransformation;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Urltransformation implements IUrltransformation {

    private static final long serialVersionUID = 1L;

    private String originalurl;
    private String shorturl;

    public Urltransformation() {}

    public Urltransformation(IUrltransformation value) {
        this.originalurl = value.getOriginalurl();
        this.shorturl = value.getShorturl();
    }

    public Urltransformation(
        String originalurl,
        String shorturl
    ) {
        this.originalurl = originalurl;
        this.shorturl = shorturl;
    }

    /**
     * Getter for <code>urlShortener.UrlTransformation.originalUrl</code>.
     */
    @Override
    public String getOriginalurl() {
        return this.originalurl;
    }

    /**
     * Setter for <code>urlShortener.UrlTransformation.originalUrl</code>.
     */
    @Override
    public void setOriginalurl(String originalurl) {
        this.originalurl = originalurl;
    }

    /**
     * Getter for <code>urlShortener.UrlTransformation.shortUrl</code>.
     */
    @Override
    public String getShorturl() {
        return this.shorturl;
    }

    /**
     * Setter for <code>urlShortener.UrlTransformation.shortUrl</code>.
     */
    @Override
    public void setShorturl(String shorturl) {
        this.shorturl = shorturl;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Urltransformation other = (Urltransformation) obj;
        if (this.originalurl == null) {
            if (other.originalurl != null)
                return false;
        }
        else if (!this.originalurl.equals(other.originalurl))
            return false;
        if (this.shorturl == null) {
            if (other.shorturl != null)
                return false;
        }
        else if (!this.shorturl.equals(other.shorturl))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.originalurl == null) ? 0 : this.originalurl.hashCode());
        result = prime * result + ((this.shorturl == null) ? 0 : this.shorturl.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Urltransformation (");

        sb.append(originalurl);
        sb.append(", ").append(shorturl);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUrltransformation from) {
        setOriginalurl(from.getOriginalurl());
        setShorturl(from.getShorturl());
    }

    @Override
    public <E extends IUrltransformation> E into(E into) {
        into.from(this);
        return into;
    }
}
