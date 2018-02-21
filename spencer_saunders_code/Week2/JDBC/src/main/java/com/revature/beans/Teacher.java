package com.revature.beans;

import java.util.Objects;

public class Teacher {

    private int id;
    private String firstname;
    private String lastname;
    private String favoriteQuote;

    public Teacher(){
                //method overloading
    }
    public Teacher(int id, String firstname, String lastname, String favoriteQuote) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.favoriteQuote = favoriteQuote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFavoriteQuote() {
        return favoriteQuote;
    }

    public void setFavoriteQuote(String favoriteQuote) {
        this.favoriteQuote = favoriteQuote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getId() == teacher.getId() &&
                Objects.equals(getFirstname(), teacher.getFirstname()) &&
                Objects.equals(getLastname(), teacher.getLastname()) &&
                Objects.equals(getFavoriteQuote(), teacher.getFavoriteQuote());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstname(), getLastname(), getFavoriteQuote());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", favoriteQuote='" + favoriteQuote + '\'' +
                '}';
    }
}
