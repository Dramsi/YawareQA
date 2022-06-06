package org.example.FileGenerator;

public class Employee {
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;
    private String group_name;

    public String getFirstName()
    {
        return firstname;
    }
    public void setFirstName(String firstname)
    {
        this.firstname = firstname;
    }
    public String getLastName()
    {
        return lastname;
    }
    public void setLastName(String lastname)
    {
        this.lastname = lastname;
    }
    public String getMiddleName()
    {
        return middlename;
    }
    public void setMiddleName(String middlename)
    {
        this.middlename = middlename;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getGroupName()
    {
        return group_name;
    }
    public void setGroupName(String group_name)
    {
        this.group_name = group_name;
    }
    public String getFullName() {
        return firstname + " " + middlename + " " + lastname;
    }
}
