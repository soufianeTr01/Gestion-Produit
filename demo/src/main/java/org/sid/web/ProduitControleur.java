package org.sid.web;

import org.sid.dao.ProduitRep;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Optional;

// annotation obligatoire
@Controller
public class ProduitControleur {
    // pour faire linjection des depandances
    @Autowired
    private ProduitRep produitrepository;
    // pour acceder a la methode (lurl)
    @RequestMapping(value = "/user/index")

    public String index(Model model, @RequestParam(name = "page",defaultValue = "0") int p, @RequestParam(name = "size",defaultValue = "5")  int s,@RequestParam(name = "motCle",defaultValue = "") String mc){
        // recupere la liste des produits
        Page<Produit> pageproduits=
                produitrepository.chercher("%"+mc+"%",PageRequest. of(p, s));
                model.addAttribute("listProduits",pageproduits.getContent());
                int []pages=new int[pageproduits.getTotalPages()];
                // tableau qui contient le nombre de page
                model.addAttribute("pages",pages);
                // ajouter lattribut size:
                model.addAttribute("size",s);
                // ajouter la page courent:

                model.addAttribute("pageCourante",p);
                // ajouter le mot cle
                model.addAttribute("mc",mc);

        return "produits";
    }
    @RequestMapping(value = "/admin/delete",method = RequestMethod.GET)
    public String delete(Long id,String mc,int page,int size){
    produitrepository.deleteById(id);
        // soit on return au page
        //return "produits";
        // soit on fait un redirect cest la méme
        return "redirect:/user/index?page="+page+"&size="+size+"&mc="+mc;
    }

    @RequestMapping(value="/admin/form",method = RequestMethod.GET)
    public String FormProduit(Model model){
        // le produit qui va ajouter
        model.addAttribute("produit",new Produit());
    return "form";
    }
    @RequestMapping(value="/admin/save",method = RequestMethod.POST)
    public String save(Model model, @Validated Produit p, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "form";
        produitrepository.save(p);
        return "confirmation";
    }
    @RequestMapping(value="/admin/editer",method = RequestMethod.GET)
    public String editer(Model model,Long id){
       Produit p=produitrepository.findById(id).orElse(null);
        model.addAttribute("produit",p);
        return "editform";
    }
    @RequestMapping(value="/",method = RequestMethod.GET)

    public String home(){

        return "redirect:/user/index";
    }
    @RequestMapping(value="/login")

    public String login(){

        return "login";
    }

    @RequestMapping(value="/403",method = RequestMethod.GET)
    public String accessDenied(){

        return "403";
        }

}
