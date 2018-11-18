package ru.jsoup.maxivanov;

public class Company {
    private int companyId;
    private String companyName;
    private String companyAddress;
    private String companyURL;

    public Company(){}

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyURL() {
        return companyURL;
    }

    public void setCompanyURL(String companyURL) {
        this.companyURL = companyURL;

        String[] id = companyURL.split("/");
        setCompanyId(Integer.valueOf(id[id.length-1]));
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!Company.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Company otherComp = (Company) obj;
        if (this.companyId != otherComp.companyId) {
            return false;
        }
        if ((this.companyName == null) ? (otherComp.companyName != null) : (!this.companyName.equals(otherComp.companyName))) {
            return false;
        }
        if ((this.companyAddress == null) ? (otherComp.companyAddress != null) : (!this.companyAddress.equals(otherComp.companyAddress))) {
            return false;
        }
        if ((this.companyURL == null) ? (otherComp.companyURL != null) : (!this.companyURL.equals(otherComp.companyURL))) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int hash = companyId;
        hash = 31 * hash + (companyName != null ? companyName.hashCode() : 0);
        hash = 31 * hash + (companyAddress != null ? companyAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Company name: '" + this.companyName +
                ((this.companyAddress==null||this.companyAddress.equals("")||this.companyAddress.equals("null"))?
                        "":("',\n\tCompany address: '" + this.companyAddress)) +
                "',\n\tCompany URL: '" + this.companyURL +"'";
    }
}
