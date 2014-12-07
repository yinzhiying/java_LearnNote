package  JavaBean;

import java.util.*;


public class ShopCar {
	private List<GoodsSingle> buylist=new ArrayList<GoodsSingle>();			
	public List<GoodsSingle> getBuylist() {
		return buylist;
	}
	public void addItem(GoodsSingle single){
		if(single!=null){
			if(buylist.size()==0){						
				GoodsSingle temp=new GoodsSingle();
				temp.setName(single.getName());
				temp.setPrice(single.getPrice());
				temp.setNum(single.getNum());
				buylist.add(temp);						
			}
			else{											
				int i=0;				
				for(;i<buylist.size();i++){					
					GoodsSingle temp=(GoodsSingle)buylist.get(i);			
					if(temp.getName().equals(single.getName())){		
						
						temp.setNum(temp.getNum()+1);			
						break;										
					}
				}
				if(i>=buylist.size()){					
					GoodsSingle temp=new GoodsSingle();
					temp.setName(single.getName());
					temp.setPrice(single.getPrice());
					temp.setNum(single.getNum());
					buylist.add(temp);				
				}
			}
		}			
	}
	
	public void removeItem(String name){
		for(int i=0;i<buylist.size();i++){				
			GoodsSingle temp=(GoodsSingle)buylist.get(i); 
			if(temp.getName().equals(MyTools.toChinese(name))){							
				if(temp.getNum()>1){						
					temp.setNum(temp.getNum()-1);			
					break;				         			
				}
				else if(temp.getNum()==1){					
					buylist.remove(i);		   				
				}
			}
		}
	}
	
	public void clearCar(){
		buylist.clear();									
	}
}