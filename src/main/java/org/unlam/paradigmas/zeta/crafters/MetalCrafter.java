package org.unlam.paradigmas.zeta.crafters;

import org.unlam.paradigmas.zeta.Inventory;
import org.unlam.paradigmas.zeta.enums.Classification;
import org.unlam.paradigmas.zeta.models.Element;
import org.unlam.paradigmas.zeta.models.Recipe;

/**
 * Catalizador para tipo metal
 * Doble de material
 */
public class MetalCrafter extends Crafter {
	 
	@Override
	public Classification type() {
	    return Classification.METAL;
	}

	@Override
	public void craft(Element element, Inventory inventory, Recipe recipe) {
	    if (!shouldApply(inventory, element)) {
	        throw new IllegalArgumentException("Este catalizador solo aplica a recetas de tipo " + type());
	    }
	
	    Element catalyst = catalyst();
	
	    for (Element ingredient : recipe.ingredients()) {
	        inventory.remove(ingredient);
	    }
	
	    inventory.remove(catalyst);

		System.out.println(element+"*2 creado con el catalizador de metal en "+recipe.time()+"ms");
	    inventory.add(element, 2);
	 }
}


