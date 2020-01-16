/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

/**
 *
 * @author Usuario
 */
class People {
    private String name;
    private String surname;
    private String departament;

    public People(String name, String surname, String departament) {
        this.name = name;
        this.surname = surname;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartament() {
        return departament;
    }

    
}
