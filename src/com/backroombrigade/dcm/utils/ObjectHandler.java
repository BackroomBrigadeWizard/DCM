package com.backroombrigade.dcm.utils;

import java.util.ArrayList;

import com.backroombrigade.dcm.gameobjects.GameObject;

public class ObjectHandler {

	private ArrayList<GameObject> objectList;
	
	public ObjectHandler(){
		objectList = new ArrayList<GameObject>();
	}
	
	public void render(){
		for(int i = 0; i < objectList.size(); i++){
			objectList.get(i).render();
		}
	}
	
	public void update(int delta){
		for(int i = 0; i < objectList.size(); i++){
			objectList.get(i).update(delta);
			if(objectList.get(i).getAlive() == false){
				objectList.get(i).setAlive(false);
				objectList.remove(i);
			}
		}
	}
	
	public GameObject getByTag(String tag){
		GameObject targetObject = null;
		
		for(int i = 0; i < objectList.size(); i++){
			if(objectList.get(i).getTag().equals(tag)){
				targetObject = objectList.get(i);
				break;
			}
		}
		
		return targetObject;
	}
	
	public void add(GameObject object){
		System.out.println(object.getTag() + " was added.");
		objectList.add(object);
	}
	
	public ArrayList<GameObject> getList(){
		return objectList;
	}
	
}
