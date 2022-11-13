package org.sid;

import org.sid.dao.ProduitRep;
import org.sid.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CatMvcApplication {

	public static void main(String[] args) {

	ApplicationContext ctx= SpringApplication.run(CatMvcApplication.class, args);
	ProduitRep produitrep=ctx.getBean(ProduitRep.class);
		Produit p1=new Produit("Linux",1500,2);
		Produit p2=new Produit("Pc Hp",9500,1);
		Produit p3=new Produit("Iphone 14",2500,1);
		Produit p4=new Produit("DGD 14",1200,20);
		Produit p5=new Produit("HDMI 14",500,50);
		Produit p6=new Produit("CAMERA 14",6500,14);
		Produit p7=new Produit("IPTV 14",8500,40);
		Produit p8=new Produit("Ecommerce",6500,10);
		Produit p9=new Produit("khiiee",6500,17);
		Produit p10=new Produit("jhjdghd",6500,15);
		Produit p11=new Produit("eiie",6500,50);
		Produit p12=new Produit("éoihddkj",6500,40);
		Produit p13=new Produit("ejiodezoez",6500,22);
		Produit p14=new Produit("eoieihoe",6500,20);
		Produit p15=new Produit("hideden",6500,30);
		Produit p16=new Produit("dihdidk",6500,14);
		Produit p17=new Produit("pojoif",6500,19);
		Produit p18=new Produit("fojfkf",6500,15);
		Produit p19=new Produit("ljojdod",6500,17);
		Produit p20=new Produit("dldjodd",6500,103);
		Produit p21=new Produit("khbifjfn",6500,130);
		Produit p22=new Produit("fihfhfio",6500,60);
		Produit p23=new Produit("rjrrij",6500,20);
		Produit p24=new Produit("kehiefihe",6500,10);

		produitrep.save(p1);
		produitrep.save(p2);
		produitrep.save(p3);
		produitrep.save(p4);
		produitrep.save(p5);
		produitrep.save(p7);
		produitrep.save(p8);
		produitrep.save(p6);
		produitrep.save(p14);
		produitrep.save(p13);
		produitrep.save(p10);
		produitrep.save(p11);
		produitrep.save(p12);
		produitrep.save(p20);
		produitrep.save(p15);
		produitrep.save(p16);
		produitrep.save(p17);
		produitrep.save(p18);
		produitrep.save(p19);
		produitrep.save(p20);
		produitrep.save(p21);
		produitrep.save(p22);
		produitrep.save(p23);
		produitrep.save(p24);
		produitrep.save(p9);
		produitrep.findAll().forEach(p-> System.out.println(p.getDesignation()));

	}

}
