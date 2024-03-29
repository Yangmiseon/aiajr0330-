package RPG;

import textrpg.items.Item;

public class Skill {

    private String name;
    private int levelRequirement;
    private Item[] itemsRequired;
    private int type;
    //1 = physical, 2 = fire, 3 = water, 4 = lightning, 5 = ice, more?!
    
    private int manaCost;
    
    public String getSkillName(){return name;}
    public void setSkillName(String n){name = n;}
    
    public int getLevelRequirement(){return levelRequirement;}
    public void setLevelRequirement(int l){levelRequirement = l;}
    
    public Item[] getItemsRequired(){return itemsRequired;}
    public void setItemsRequired(Item[] i){itemsRequired = i;}
    
    public int getManaCost(){return manaCost;}
    public void setManaCost(int i){manaCost = i;}
    
    public int getType(){return type;}
    public void setType(int i){type = i;}
    
    public int use(){return -1;}//ALL SKILLS MUST OVERRIDE THIS
    //should make an interface
}