/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wofieballdraftkit.data;

import java.util.ArrayList;
import wofieballdraftkit.file.DraftFileManager;


/**
 *
 * @author MiChAeL
 */
public class DraftDataManager {    
    
    
   static ArrayList<Player> playerPool = new ArrayList();

    
    Draft draft;
    DraftDataView view;
    DraftFileManager fileManager;
    
    

    
    
    
    
    public DraftDataManager(DraftDataView initView, ArrayList<Pitcher> p,ArrayList<Hitter> h ){
         
        view = initView;
        
        for(int i = 0; i<p.size();i++){
         playerPool.add((Player)p.get(i));
        }
        
        for(int i = 0; i<h.size();i++){
         playerPool.add((Player)h.get(i));
        }    
        
        draft = new Draft(playerPool);
        
    }
    
    public Draft getDraft(){
        return draft;
    }
    
    public DraftFileManager getFileManager() {
       return fileManager;
    }
    
    
      public void reset() {
        // CLEAR ALL THE COURSE VALUES
       
        
        // AND THEN FORCE THE UI TO RELOAD THE UPDATED COURSE
        view.reloadDraft(draft);
    }
    

    public ArrayList<Player> getPlayerList() {
        return playerPool;
    }

    public void setPlayerList(ArrayList<Player> playerPool) {
        this.playerPool = playerPool;
    }

}
