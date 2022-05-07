package com.blue.demo.services;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blue.demo.entities.Adresse;
import com.blue.demo.entities.Article;
import com.blue.demo.entities.Boutique;
import com.blue.demo.entities.Categorie;
import com.blue.demo.entities.City;
import com.blue.demo.entities.Commande;
import com.blue.demo.entities.Commande_prod;
import com.blue.demo.entities.Compte;
import com.blue.demo.entities.Etatcommande;
import com.blue.demo.entities.Favoris;
import com.blue.demo.entities.Gender;
import com.blue.demo.entities.Livraison;
import com.blue.demo.entities.Modelivraison;
import com.blue.demo.entities.Newsletter;
import com.blue.demo.entities.Privilege;
import com.blue.demo.entities.State;
import com.blue.demo.entities.Taille;
import com.blue.demo.entities.Taille_prod;
import com.blue.demo.entities.User;

import com.blue.demo.dao.NewsletterRepository;

import com.blue.demo.dao.AdresseRepository;
import com.blue.demo.dao.ArticleRepository;
import com.blue.demo.dao.BoutiqueRepository;
import com.blue.demo.dao.CategorieRepository;
import com.blue.demo.dao.CityRepository;
import com.blue.demo.dao.CommandeRepository;
import com.blue.demo.dao.Commande_prodRepository;
import com.blue.demo.dao.CompteRepository;
import com.blue.demo.dao.EtatcommandeRepository;
import com.blue.demo.dao.FavorisRepository;
import com.blue.demo.dao.GenderRepository;
import com.blue.demo.dao.LivraisonRepository;
import com.blue.demo.dao.ModelivraisonRepository;
import com.blue.demo.dao.PrivilegeRepository;
import com.blue.demo.dao.StateRepository;
import com.blue.demo.dao.TailleRepository;
import com.blue.demo.dao.Taille_prodRepository;
import com.blue.demo.dao.UserRepository;

@RestController
@CrossOrigin("*")
public class WebController {
	
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private TailleRepository tailleRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private Taille_prodRepository taille_prodRepository;
	@Autowired
	private GenderRepository genderRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LivraisonRepository livraisonRepository;
	@Autowired
	private BoutiqueRepository boutiqueRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PrivilegeRepository privilegeRepository;
	@Autowired
	private ModelivraisonRepository modelivraisonRepository;
	@Autowired
	private EtatcommandeRepository etatcommandeRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private Commande_prodRepository commande_prodRepository ;
	@Autowired
	private NewsletterRepository NewsletterRepository ;
	@Autowired
	private FavorisRepository favorisRepository ;
	
	///////////////////////////////////Favoris//////////////////////////////
	
	@RequestMapping("articlefavorie")
	public Favoris articlefavorie(Long id){
	 return favorisRepository.articlefavorie(id);
	}
	
	///////////all
	@RequestMapping("favoris/all")
	public List<Favoris> getfavoris() {
		return   favorisRepository.findAll();
		}
	//////////get
	@RequestMapping("favoris/getfavoris")
	public Optional<Favoris> getfavoris(Long id){
	return favorisRepository.findById(id);
	}
	
	//////////get avec des modification
	@RequestMapping("favoris/get")
	public Optional<Favoris> getfavoris2(Long user,Long article){
	return favorisRepository.IfInFavorisListe(user,article);
	}

	
	
	
	//////////add
	@RequestMapping("favoris/add")
	public String addfavoris(Model model) {
		model.addAttribute("favoris",new Favoris() );
		return "addfavoris";
	}
	
	
	/////////save
	@RequestMapping("favoris/save")
	public Favoris savefavoris(Favoris F ) {
		favorisRepository.save(F);
		return F;
		
	}
	
	/////////delete
	@RequestMapping("favoris/delete")
	public String deletefavoris(Long user,Long article){
		
		//try {
		favorisRepository.deleteFavoris(user,article);
		return "true";
		//}catch(Exception e) {
		//	return "false";}
		
	}
	
	
	/////////update
	@RequestMapping("favoris/update")
	public Favoris update(Favoris F){
		return favorisRepository.saveAndFlush(F);
	}
///////////////////////////////////Taille_prod//////////////////////////////
	
///////////all
@RequestMapping("taille_prod/all")
public List<Taille_prod> getTaille_prod() {
return   taille_prodRepository.findAll();
}
//////////get
@RequestMapping("taille_prod/get")
public Optional<Taille_prod> getTaille_prod(Long id){
return taille_prodRepository.findById(id);
}
 


/////////save
@RequestMapping("taille_prod/save")
public Taille_prod saveTaille_prod(Taille_prod T ) {
	taille_prodRepository.save(T);
return T;

}

/////////delete
@RequestMapping("taille_prod/delete")
public String deleteTaille_prod(Long id){
try {
int id2=  id.intValue();
taille_prodRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}


/////////update
@RequestMapping("taille_prod/update")
public Taille_prod updateTaille_prod(Taille_prod T){
return taille_prodRepository.saveAndFlush(T);
}


/////////update_size
@RequestMapping("taille_prod/updateQuantite")
public int updateSize(Long id_article, Long id_taille, int qte){
return taille_prodRepository.updateSize(id_article,id_taille,qte);
}

	///////////////////////////////////Commande//////////////////////////////
	
	///////////all
	@RequestMapping("commande/all")
	public List<Commande> getCommande() {
		return   commandeRepository.findAll();
		}
	//////////get
	@RequestMapping("commande/getcommande")
	public Optional<Commande> getCommande(Long id){
	return commandeRepository.findById(id);
	}
	
	//////////add
	@RequestMapping("commande/add")
	public String addCommande(Model model) {
		model.addAttribute("commande",new Commande() );
		return "addCommande";
	}
	
	
	/////////save
	@RequestMapping("commande/save")
	public Commande saveCommande(Commande C ) {
		commandeRepository.save(C);
		return C;
		
	}
	
	/////////delete
	@RequestMapping("commande/delete")
	public String deletecommande(Long id){
		try {
		int id2=  id.intValue();
		commandeRepository.deleteById(id);
		return "true";
		}
		catch(Exception e) {
			
			return "false";
			}
		
	}
	
	
	/////////update
	@RequestMapping("commande/update")
	public Commande update(Commande C){
		return commandeRepository.saveAndFlush(C);
	}
	
	/////////update modifié
	@RequestMapping("commande/modifEtat")
	public int modifEtat(Long id,Long etat){
		return commandeRepository.ModifCommande(id, etat);
	}
	
	
/////////somme nb commande
@RequestMapping("/sommecommande")
public int commandes(){
return commandeRepository.commandes();
}

/////////somme nb commande
@RequestMapping("/chiffreaffaire")
public int commandestotal(){
return commandeRepository.commandestotal();
}
///////////////////////////////////Newsletter//////////////////////////////
	
///////////all
@RequestMapping("newsletter/all")
public List<Newsletter> getNewsletter() {
return   NewsletterRepository.findAll();
}
//////////get
@RequestMapping("newsletter/get")
public Optional<Newsletter> getNewsletter(Long id){
return NewsletterRepository.findById(id);
}



/////////save
@RequestMapping("newsletter/save")
public Newsletter saveNewsletter(Newsletter C ) {
	NewsletterRepository.save(C);
return C;

}

/////////delete
@RequestMapping("newsletter/delete")
public String deleteNewsletter(Long id){
try {
int id2=  id.intValue();
NewsletterRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}

}


/////////update
@RequestMapping("newsletter/update")
public Newsletter update(Newsletter C){
return NewsletterRepository.saveAndFlush(C);
}

///////////////////////////////////Taille//////////////////////////////
	
///////////all
@RequestMapping("taille/all")
public List<Taille> getTaille() {
return   tailleRepository.findAll();
}
//////////get
@RequestMapping("taille/gettaille")
public Optional<Taille> getTaille(Long id){
return tailleRepository.findById(id);
}

//////////get
@RequestMapping("taille/getTailleNom")
public Long getTailleNom(String t){
return tailleRepository.findBylib_taille(t);
}

//////////add
@RequestMapping("taille/add")
public String addTaille(Model model) {
model.addAttribute("taille",new Taille() );
return "addTaille";
}


/////////save
@RequestMapping("taille/save")
public Taille saveTaille(Taille T ) {
tailleRepository.save(T);
return T;

}

/////////delete
@RequestMapping("taille/delete")
public String deletetaille(Long id){
try {
int id2=  id.intValue();
tailleRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}

}


/////////update
@RequestMapping("taille/update")
public Taille update(Taille T){
return tailleRepository.saveAndFlush(T);
}


	
	////////////////////////////////////Article//////////////////////////////
	@RequestMapping("article/all")
	public List<Article> getArticles() {
		return   articleRepository.findAll();
		}
	
	@RequestMapping("article/page")
	public Page<Article> pagination(int page){
	 	return articleRepository.findAll(PageRequest.of(page, 2));
	}
/*
	@RequestMapping("/article/page")
	public List<Article> pagenation(int from){
	return articleRepository.findSixArticles(from);
	}
	
	@RequestMapping("/article/page")
	public Page<Article> pagination(){
 	Page<Article> allProducts = articleRepository.findAll(0,5	z");
	 return   allProducts;
	
	}
	
	*/
	
	@RequestMapping("article/get")
	public Optional<Article> getArticle(Long id){
	return articleRepository.findById(id);
	}


	
	@RequestMapping("article/save")
	public Article saveArticle(Article A ) {
		A.setActive(true);
		articleRepository.save(A);
		return A;
		
	}
	

	@RequestMapping("article/update")
	public Article update(Article A){
		return articleRepository.saveAndFlush(A);
	//http://localhost:8080/article/update?id_article=12&description_article=description&designation=helloworld&img_article=this&note=4&prix=100&quantite_stock=30&taux_remise=25&taux_tva=8&id_categorie=8
	}
	
	
	@RequestMapping("article/delete")
	public String deletearticle(Long id){
		try {
		int id2=  id.intValue();
		articleRepository.deleteById(id);
		return "true";
		}
		catch(Exception e) {
			
			return "false";
			}
		
	}
	//////////////////recherche article by designation
	@RequestMapping("article/recherche")
	public List<Article> findbydesignation(String des){
	return articleRepository.findbydesignation("%"+des+"%");
	}
	
	
/////////somme nb articles
@RequestMapping("/sommearticle")
public int articless(){
return articleRepository.articles();
}

//////////////////Categories//////////////////////////

//affiche all 
@RequestMapping("categorie/all")
public List<Categorie> getcategories() {
return   categorieRepository.findAll();
}

@RequestMapping("categorie/get")
public Optional<Categorie> getCategorie(Long id){
return categorieRepository.findById(id);
}

@RequestMapping("categorie/add")
public String addCategorie(Model model) {
model.addAttribute("categorie",new Categorie() );
return "categorie/save";
}

@RequestMapping("categorie/save")
public Categorie saveCategorie(Categorie C ) {
categorieRepository.save(C);
return C;

}

@RequestMapping("categorie/delete")
public String deletecategorie(Long id){
try {
int id2=  id.intValue();
categorieRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}

}

@RequestMapping("categorie/update")
public Categorie update(Categorie C){
return categorieRepository.saveAndFlush(C);
}
/*
@RequestMapping("Liste_categorie")
public List<Gender> getListeCategorie(String gender){
return categorieRepository.Liste_categorie(gender);
}
*/
	//////////////////livraison//////////////////////////

/////////all livraison
	@RequestMapping("livraison/all")
	public List<Livraison> getlivraison() {
		return  livraisonRepository.findAll();
		}

	/////////get livraison
	@RequestMapping("livraison/get")
	public Optional<Livraison> getLivraison(Long id){
	return livraisonRepository.findById(id);
	}

	/////////save livraison
	@RequestMapping("livraison/save")
	public Livraison saveLivraison(Livraison L ) {
		livraisonRepository.save(L);
		return L;
		
	}

	/////////delete livraison
	@RequestMapping("livraison/delete")
	public String deletelivraison(Long id){
		try {
		int id2=  id.intValue();
		livraisonRepository.deleteById(id);
		return "true";
		}
		catch(Exception e) {
			
			return "false";
			}
		
	}

	/////////update livraison
	@RequestMapping("livraison/update")
	public Livraison update(Livraison L){
		return livraisonRepository.saveAndFlush(L);
	}
	
	@RequestMapping("/historique/lister")
	public List<Livraison> historique(Long id){
	return livraisonRepository.historique(id);
	}
	//////////////////Boutique//////////////////////////

/////////all boutique
	@RequestMapping("boutique/all")
	public List<Boutique> getBoutique() {
		return  boutiqueRepository.findAll();
		}

	/////////get boutique
	@RequestMapping("boutique/get")
	public Optional<Boutique> getBoutique(Long id){
	return boutiqueRepository.findById(id);
	}

/////////save boutique

	@RequestMapping("boutique/save")
	public Boutique saveBoutique(Boutique B ) {
		boutiqueRepository.save(B);
		return B;
		
	}
/////////delete boutique

	@RequestMapping("boutique/delete")
	public String deleteboutique(Long id){
		try {
		int id2=  id.intValue();
		boutiqueRepository.deleteById(id);
		return "true";
		}
		catch(Exception e) {
			
			return "false";
			}
		
	}
/////////update boutique
	@RequestMapping("boutique/update")
	public Boutique update(Boutique B){
		return boutiqueRepository.saveAndFlush(B);
	}

	
	///////////////////////////////////Gender//////////////////////////////
	
///////////all gender
@RequestMapping("gender/all")
public List<Gender> getGender() {
	return   genderRepository.findAll();
	}
//////////get gender
@RequestMapping("gender/getgender")
public Optional<Gender> getGender(Long id){
return genderRepository.findById(id);
}

/////////save gender
@RequestMapping("gender/save")
public Gender saveGender(Gender T ) {
	genderRepository.save(T);
	return T;
	
}

/////////delete gender
@RequestMapping("gender/delete")
public String deletegender(Long id){
	try {
	int id2=  id.intValue();
	genderRepository.deleteById(id);
	return "true";
	}
	catch(Exception e) {
		
		return "false";
		}
}


/////////update gender
@RequestMapping("gender/update")
public Gender updategender(Gender T){
	return genderRepository.saveAndFlush(T);
}
///////////////////////////////////User//////////////////////////////

@RequestMapping("/user_Compte")
public User UserToCompte(Long id){
 return userRepository.UserToCompte(id);
}

@RequestMapping("/user/login")
public Compte authentification(String login,String password){
return compteRepository.findUser(login,password);
}
@RequestMapping("/user/getlogin")
public Compte finduserparlogin(String login){
return compteRepository.findLogin(login);
}

///////////all user
@RequestMapping("user/all")
public List<User> getuser() {
return   userRepository.findAll();
}

//////////get user
@RequestMapping("user/get")
public Optional<User> getuser(Long id){
return userRepository.findById(id);
}

/////////save user
@RequestMapping("user/save")
public User saveuser(User U ) {
	
	userRepository.save(U);
return U;

}

//commande_adomicil
@RequestMapping("/staff/lister")
public List<User> staff(){
return userRepository.staff();
}
 

/////////delete user
@RequestMapping("user/delete")
public String deleteuser(Long id){
try {
int id2=  id.intValue();
userRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}


/////////update user
@RequestMapping("user/update")
public User updateuser(User U){
return userRepository.saveAndFlush(U);
}

/////////somme nb users
@RequestMapping("/sommeusers")
public int users(){
return userRepository.users();
}
///////////////////////////////Compte//////////////////////////////

///////////all compte
@RequestMapping("compte/all")
public List<Compte> getcompte() {
return  compteRepository.findAll();
}
//////////get compte
@RequestMapping("compte/get")
public Optional<Compte> getcompte(Long id){
return compteRepository.findById(id);
}

/////////save compte
@RequestMapping("compte/save")
public Compte savecompte(Compte C ) {
	C.setActive(true);
	if (compteRepository.existsByLogin(C.getLogin())) {
		return null;
	}
	compteRepository.save(C);
return C;

}

/////////delete compte
@RequestMapping("compte/delete")
public String deletecompte(Long id){
try {
int id2=  id.intValue();
compteRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}

/////////update compte
@RequestMapping("compte/update")
public Compte updatecompte(Compte C){
return compteRepository.saveAndFlush(C);
}

///////////////////////////////Commande_prod//////////////////////////////

//recherch Articles de Client
@RequestMapping("/vos_commande/lister")
public List<Commande> vos_commande(Long id){
return commandeRepository.vos_commande(id);
}

//commande_adomicil
@RequestMapping("/commande_adomicil/lister")
public List<Commande> commande_adomicil(String state){
return commandeRepository.commande_adomicil(state);
}
/*
@RequestMapping("/vos_commande/get")
public List<Commande> vos_commandeget(Long id,Long id2){
return commandeRepository.vos_commandeget(id,id2);
}
*/

///////////all commande_prod
@RequestMapping("commande_prod/all")
public List<Commande_prod> getcommande_prod() {
return  commande_prodRepository.findAll();
}
//////////get commande_prod
@RequestMapping("commande_prod/get")
public Optional<Commande_prod> getcommande_prod(Long id){
return commande_prodRepository.findById(id);
}

/////////save commande_prod
@RequestMapping("commande_prod/save")
public Commande_prod ommande_prod(Commande_prod C ) {
	commande_prodRepository.save(C);
return C;

}

/////////delete commande_prod
@RequestMapping("ommande_prod/delete")
public String deletecommande_prod(Long id){
try {
int id2=  id.intValue();
commande_prodRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}

/////////update commande_prod
@RequestMapping("commande_prod/update")
public Commande_prod updatecommande_prod(Commande_prod C){
return commande_prodRepository.saveAndFlush(C);
}

/////////satat etatcommande
@RequestMapping("/statcategorie")
public List stat_categorie(){
return commande_prodRepository.stat_categorie();
}

///////////////////////////////////Privilege//////////////////////////////

///////////all privilege
@RequestMapping("privilege/all")
public List<Privilege> getprivilege() {
return   privilegeRepository.findAll();
}
//////////get privilege
@RequestMapping("privilege/getprivilege")
public Optional<Privilege> getprivilege(Long id){
return privilegeRepository.findById(id);
}

/////////save privilege
@RequestMapping("privilege/save")
public Privilege saveprivilege(Privilege P ) {
	privilegeRepository.save(P);
return P;

}

/////////delete privilege
@RequestMapping("privilege/delete")
public String deleteprivilege(Long id){
try {
int id2=  id.intValue();
privilegeRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}


/////////update privilege
@RequestMapping("privilege/update")
public Privilege updateprivilege(Privilege P){
return privilegeRepository.saveAndFlush(P);
}
///////////////////////////////////Etatcommande//////////////////////////////

///////////all etatcommande
@RequestMapping("etatcommande/all")
public List<Etatcommande> getetatcommande() {
return  etatcommandeRepository.findAll();
}
//////////get etatcommande
@RequestMapping("etatcommande/getetatcommande")
public Optional<Etatcommande> getetatcommande(Long id){
return etatcommandeRepository.findById(id);
}

/////////save etatcommande
@RequestMapping("etatcommande/save")
public Etatcommande saveetatcommande(Etatcommande E ) {
	etatcommandeRepository.save(E);
return E;

}

/////////delete etatcommande
@RequestMapping("etatcommande/delete")
public String deleteetatcommande(Long id){
try {
int id2=  id.intValue();
etatcommandeRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}


/////////update etatcommande
@RequestMapping("etatcommande/update")
public Etatcommande updateetatcommande(Etatcommande E){
return etatcommandeRepository.saveAndFlush(E);
}


/////////satat etatcommande
@RequestMapping("/statetat")
public List stat(){
return commandeRepository.stat_etat();
}

/////////satat date
@RequestMapping("/statdate")
public List stat_date(){
return commandeRepository.stat_date();
}
///////////////////////////////////Adresse//////////////////////////////

///////////all Adresse
@RequestMapping("adresse/all")
public List<Adresse> getadresse() {
return   adresseRepository.findAll();
}
//////////get adresse
@RequestMapping("adresse/getadresse")
public Optional<Adresse> getadresse(Long id){
return adresseRepository.findById(id);
}

/////////save adresse
@RequestMapping("adresse/save")
public Adresse saveadresse(Adresse A ) {
	adresseRepository.save(A);
return A;

}

/////////delete adresse
@RequestMapping("adresse/delete")
public String delete(Long id){
try {
int id2=  id.intValue();
adresseRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}

/////////update adresse
@RequestMapping("adresse/update")
public Adresse updateadresse(Adresse A){
return adresseRepository.saveAndFlush(A);
}

///////////////////////////////////State//////////////////////////////

///////////all state
@RequestMapping("state/all")
public List<State> getstate() {
return   stateRepository.findAll();
}
//////////get state
@RequestMapping("state/getstate")
public Optional<State> getstate(Long id){
return stateRepository.findById(id);
}

/////////save state
@RequestMapping("state/save")
public State savestate(State S ) {
	stateRepository.save(S);
return S;

}

/////////delete state
@RequestMapping("state/delete")
public String deletestate(Long id){
try {
int id2=  id.intValue();
stateRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}

/////////update state
@RequestMapping("state/update")
public State updatestate(State S){
return stateRepository.saveAndFlush(S);
}

/////////////////////////////////City//////////////////////////////

/////////all city
@RequestMapping("city/all")
public List<City> getcity() {
return   cityRepository.findAll();
}
//////////get city
@RequestMapping("city/getcity")
public Optional<City> getcity(Long id){
return cityRepository.findById(id);
}

/////////save city
@RequestMapping("city/save")
public City savecity(City M ) {
	cityRepository.save(M);
return M;

}

/////////delete city
@RequestMapping("city/delete")
public String deletecity(Long id){
try {
int id2=  id.intValue();
cityRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}

/////////update city
@RequestMapping("city/update")
public City updatecity(City C){
return cityRepository.saveAndFlush(C);
}

///////////////////////////////////Modelivraison//////////////////////////////

///////////all modelivraison
@RequestMapping("modelivraison/all")
public List<Modelivraison> getmodelivraison() {
return   modelivraisonRepository.findAll();
}
//////////get modelivraison
@RequestMapping("modelivraison/getmodelivraison")
public Optional<Modelivraison> getmodelivraison(Long id){
return modelivraisonRepository.findById(id);
}

/////////save modelivraison
@RequestMapping("modelivraison/save")
public Modelivraison savemodelivraison(Modelivraison M ) {
modelivraisonRepository.save(M);
return M;

}

/////////delete modelivraison
@RequestMapping("modelivraison/delete")
public String deletemodelivraison(Long id){
	
try {
int id2=  id.intValue();
modelivraisonRepository.deleteById(id);
return "true";
}
catch(Exception e) {

return "false";
}
}

/////////update modelivraison
@RequestMapping("modelivraison/update")
public Modelivraison updatemodelivraison(Modelivraison M){
return modelivraisonRepository.saveAndFlush(M);
}

	
}
