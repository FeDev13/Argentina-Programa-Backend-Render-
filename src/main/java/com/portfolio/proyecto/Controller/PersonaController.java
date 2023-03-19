
package com.portfolio.proyecto.Controller;

import com.portfolio.proyecto.Entity.Persona;
import com.portfolio.proyecto.Interface.IPersonaInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfoliofedericorobledo.web.app/")
public class PersonaController {
    @Autowired IPersonaInterface iPersonaInterface;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
    return iPersonaInterface.getPersona();
    }
    
    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
    iPersonaInterface.savePersona(persona);
    return "la persona fue creada con exito";
    }
    
    @PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/[id]")
    public String deletePersona(@PathVariable Long id){
    iPersonaInterface.deletePersona(id);
    return "la persona fue eliminada";
    }
    @PreAuthorize ("hasRole('ADMIN')")
   @PutMapping("/personas/editar/[id]")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre")String nuevoNombre,
                               @RequestParam("apellido")String nuevoApellido,
                               @RequestParam("img")String nuevoImg){
    Persona persona = iPersonaInterface.findPersona(id);
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);
    persona.setImg(nuevoImg);
    
    iPersonaInterface.savePersona(persona);
    return persona;
    }
    @GetMapping("personas/traer/perfil")
    public Persona findPersona(){
    return iPersonaInterface.findPersona((long)1);
    }
    }



