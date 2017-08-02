package com.example.demoSpring.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoSpring.model.Fabricante;
import com.example.demoSpring.model.Municipio;
import com.example.demoSpring.model.DaoFabricante;
import com.example.demoSpring.model.DaoMunicipio;
import com.example.demoSpring.model.DaoArticulo;
import com.example.demoSpring.model.Articulo;


@Controller
public class MainController {
	
	@Autowired
    private DaoFabricante daoFabricante;
	@Autowired
    private DaoArticulo daoArticulo;
	@Autowired
    private DaoMunicipio daoMunicipio;
   
		
		String men = "Hola mundo!";
		ArrayList<Fabricante> listaAlumnos = new ArrayList<Fabricante>();
		
		@RequestMapping(value="/", method = RequestMethod.GET)
		public String home (Model model)
		{
			
			Fabricante fabricante = new Fabricante();   
	        
	        model.addAttribute("mensaje", men);
	        model.addAttribute("fab",fabricante);
			
			return "homepage";
		}
		
		@RequestMapping(value="/createfabricante", method = RequestMethod.POST)
		public String doingPost(Model model, @ModelAttribute Fabricante fabri,
				@RequestParam String nombremuni, @RequestParam String nombreinte) //, @RequestParam String comment)
		//public String indexReq(Model model, @ModelAttribute Libro libro, String autor)
		{
			System.out.println(fabri.getNombre());
			//listaAlumnos.add(alum);
		     //model.addAttribute("listaalum",listaAlumnos);
			 Articulo art = new Articulo("Tornillo",1200.34f);
			 
			 
				List<Municipio> buscaMuni = daoMunicipio.findBynombre(nombremuni);
				
				if (buscaMuni.size() > 0) System.out.println("Encontro la muni");
				else  System.out.println("No Encontro la muni") ;
			 
			 Municipio muni = new Municipio(nombremuni,nombreinte);
			 //	 fabri = daoFabricante.findOne((long)1);
			 fabri.agregoArticulo(art);
			 muni.agregoFabricante(fabri);
			
			
		     daoFabricante.save(fabri);
		     Iterable<Fabricante> listaBase = daoFabricante.findAll();
		     for(Fabricante al: listaBase)
		     {
		    	 System.out.println("nombre:" + al.getNombre());
		    	 System.out.println("nombre:" + al.getMunicipio().getNombre() + " " + al.getMunicipio().getIntendente());
		     }
		     model.addAttribute("listafabri",listaBase);
		     
	/*	     System.out.println("findOne:"+daoFabricante.findOne((long)3).getNombre());
		     //System.out.println("findbyNombre:"+daoAlumno.findByNombre("jose").getApellido());
		     Iterable<Fabricante> listaNombres = daoFabricante.findByNombre("jose"); 
		     for(Fabricante al: listaNombres)
		     {
		    	 System.out.println("nombre:" + al.getNombre() );
		     }
		    
			*/
		     
			return "agregado";
		}
		
			
		
		@RequestMapping(value="/addlist", method = RequestMethod.GET)
		public String addlist ()
		{
			
			      
	        
	      //  model.addAttribute("mensaje", men);
			
			return "addlist";
		}
		
	

	}
