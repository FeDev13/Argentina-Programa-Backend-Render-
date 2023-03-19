
package com.portfolio.proyecto.Interface;

import com.portfolio.proyecto.Entity.Persona;
import java.util.List;


public interface IPersonaInterface {
    public List <Persona> getPersona();
    public void savePersona(Persona persona);
    public void deletePersona (Long id);
    public Persona findPersona(Long id);
}
