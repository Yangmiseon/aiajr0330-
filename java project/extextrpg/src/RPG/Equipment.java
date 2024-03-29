package RPG;

import textrpg.items.Item;

public class Equipment extends Item {
    private int equipmentType; //the type of equipment it is
    //1 = weapon, 2 = chest, 3 = legs, 4 = bracers, 5 = boots, 6 = gloves
    //7 = shield, 8 = offhand, 9 = ring, 10 = hat, 11 = goggles
    
    private int[] equipmentStats; //an array of stats that the equipment modifies
    //HP, MP, STR, MAG, AGI, DEF, MDEF
    
    public int getEquipmentType(){return equipmentType;}
    public void setEquipmentType(int e){equipmentType = e;}
    
    public int[] getEquipmentStats(){return equipmentStats;}
    public void setEquipmentStats(int[] e){equipmentStats = e;}
}
