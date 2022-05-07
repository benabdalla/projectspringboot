package com.blue.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.blue.demo.entities.Commande;

@Transactional
public interface CommandeRepository extends JpaRepository<Commande, Long> {

 	 @Query("SELECT c FROM Commande c where id_user= :id order by id_cmd desc ") 
	 public  List<Commande> vos_commande(@Param("id") Long id);
 	
 	 @Query("SELECT c FROM Commande c where id_boutique =null and etatcommande.etatcmd='confirmé' and c.adresse.City.state.lib_state= :state") 
	 public  List<Commande> commande_adomicil(@Param("state") String state);
 	 /*
 	 @Query("SELECT c FROM Commande c where id_cmd= :id and  user= :id2 ") 
	 public  List<Commande> vos_commandeget(@Param("id") Long id,@Param("id_user") Long id2);
	 */
 	@Modifying
	@Query("Update Commande c set etatcommande.id_etatcmd= :etat where c.id_cmd= :id")
	int ModifCommande(@Param("id") Long id, @Param("etat") Long etat);
 	 
 	@Query("SELECT count(c) FROM Commande c  ") 
	 public  int  commandes();
 	
 	@Query("SELECT SUM(prix_total) FROM Commande c  ") 
	 public  int  commandestotal();
 	
 	@Query("SELECT c.etatcommande.etatcmd,count(c) FROM Commande c group by c.etatcommande.etatcmd ") 
	 public  List stat_etat( );
 	@Query("SELECT CASE  WHEN SUBSTRING(c.date_cmd,1,2)='1-' THEN 'Janvier'"
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='2-' THEN 'Fevrier' "
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='3-' THEN 'mars'"
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='4-' THEN 'avril'"
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='5-' THEN 'mai'"
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='6-' THEN 'juin'"
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='7-' THEN 'juillet'"
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='8-' THEN 'aout'"
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='9-' THEN 'septembre'"
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='10' THEN 'octobre'"
 			+ "  WHEN SUBSTRING(c.date_cmd,1,2)='11' THEN 'novembre'"
 			+ "ELSE  'decembre'" + 
 			"    END ,count(*),CASE  WHEN SUBSTRING(c.date_cmd,1,2)='1-' THEN 'a'" + 
 			 "  WHEN SUBSTRING(c.date_cmd,1,2)='2-' THEN 'b'  " + 
 			 "  WHEN SUBSTRING(c.date_cmd,1,2)='3-' THEN 'c'" + 
 		 "  WHEN SUBSTRING(c.date_cmd,1,2)='4-' THEN 'd' " + 
 		 "  WHEN SUBSTRING(c.date_cmd,1,2)='5-' THEN 'e' " + 
 			 "  WHEN SUBSTRING(c.date_cmd,1,2)='6-' THEN 'f' " + 
 			 "  WHEN SUBSTRING(c.date_cmd,1,2)='7-' THEN 'g' " + 
 			 "  WHEN SUBSTRING(c.date_cmd,1,2)='8-' THEN 'h' " + 
 			 "  WHEN SUBSTRING(c.date_cmd,1,2)='9-' THEN 'i' " + 
 			 "  WHEN SUBSTRING(c.date_cmd,1,2)='10' THEN 'j' " + 
 			"  WHEN SUBSTRING(c.date_cmd,1,2)='11' THEN 'k' " + 
 			 "ELSE  'l'" + 
 			 "    END  as mois FROM Commande  c group by SUBSTRING(c.date_cmd,1,2)  order by mois") 
	 public  List stat_date( );
 	
}