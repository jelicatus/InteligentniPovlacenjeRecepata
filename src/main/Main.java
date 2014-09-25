/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import domen.AgregatniRejting;
import domen.NutritivneInformacije;
import domen.Recept;
import java.util.List;
import parseri.AllRecipeParser;
import parseri.YummlyParser;
import persistence.RDFModel;
import persistence.DataModelManager;
import util.URIGenerator;

/**
 *
 * @author M&J
 */
public class Main {

    public static void main(String[] args) {
        YummlyParser povezivanjeYummly = new YummlyParser();
        AllRecipeParser arp = new AllRecipeParser();
        RDFModel model = RDFModel.getInstance();

        DataModelManager m = DataModelManager.getInstance();
        try {
            List<Recept> receptiYummly = povezivanjeYummly.vratiRecepte("chicken");
            System.out.println("Recepti yummly");
            System.out.println("broj yummly recepata " + receptiYummly.size());
            int i = 1;
            for (Recept recept : receptiYummly) {
                System.out.println(i);
                i++;
                recept.setUri(URIGenerator.generate(recept));
                NutritivneInformacije ni = recept.getNutritivneInformacije();
                if (ni != null) {
                    ni.setUri(URIGenerator.generate(ni));
                    m.save(ni);
                    model.save(ni);
                }
                AgregatniRejting ar = recept.getRejting();
                ar.setUri(URIGenerator.generate(ar));
                m.save(ar);
                model.save(ar);

                System.out.println(recept.getUri());
                m.save(recept);
                model.save(recept);
            }

            System.out.println("Recepti allrecipe");
            List<Recept> receptiAllRecipe = arp.vratiRecepte("chicken");
            System.out.println("BROJ RECEPATA ALLRECIPE: " + receptiAllRecipe.size());
            for (Recept recept : receptiAllRecipe) {
                System.out.println("usao");
                recept.setUri(URIGenerator.generate(recept));
                NutritivneInformacije ni = recept.getNutritivneInformacije();
                ni.setUri(URIGenerator.generate(ni));
                m.save(ni);
                model.save(ni);
                AgregatniRejting ar = recept.getRejting();
                ar.setUri(URIGenerator.generate(ar));
                m.save(ar);
                model.save(ar);

                System.out.println(recept.getUri());
                m.save(recept);
                model.save(recept);
            }
            
            model.saveModel();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        DataModelManager.getInstance().closeDataModel();
    }

}
