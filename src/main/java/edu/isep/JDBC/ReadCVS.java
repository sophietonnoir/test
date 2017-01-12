package edu.isep.JDBC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.util.ArrayList;

public class ReadCVS {
    private String numero;
    private  String nom;
    private String etape;
    private String promotion;
    private String statut;
    private String apprentissage;
    public void listf(String directoryName, ArrayList<String> files) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file.getName());
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }

    public void run(User user) {
        String folder = "parcours";
        String csvFile = "";
        ArrayList<String> csvFiles=new ArrayList<String>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int userFound=0;
        Class myClass=getClass();
//Récupération des repository
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ParcoursRepository repoP=ctx.getBean(ParcoursRepository.class);
        FicheRepository repoF=ctx.getBean(FicheRepository.class);
        UserRepository repoUser=ctx.getBean(UserRepository.class);

        try {
            ClassLoader loader=myClass.getClassLoader();
            listf(loader.getResource(folder).getPath(),csvFiles);
            for(int i=0;i<csvFiles.size();i++){
                System.out.println("BOUCLE :"+i);
                csvFile="parcours/"+csvFiles.get(i);
                br = new BufferedReader(new FileReader(loader.getResource(csvFile).getPath()));
                String nomParcours=br.readLine().split(";")[1];
                nomParcours=nomParcours.split("Promo")[0];

                int register=0;
                for(Parcours parcours:repoP.findAll()){
                    if (parcours.getNomparcours().equals(nomParcours)){
                        register=1;
                        break;
                    }
                }
                //Si le parcours n'est pas inscrit, on l'enregistre
                if (register!=1){
                    Parcours parcours=new Parcours(nomParcours,"");
                    repoP.save(parcours);
                }
                br.readLine();
                while (((line = br.readLine()) != null)) {
                    String[] data = line.split(cvsSplitBy);
                    numero=data[0].trim();
                    if (!numero.equals("Total")){
                        if(numero.equals(user.getNumber())) {
                            nom=data[1].trim();
                            etape=data[2].trim();
                            promotion = data[3].trim();
                            statut=data[4].trim();
                            apprentissage=data[5].trim();
                            Fiche fiche = repoF.findOne(user);
                            fiche.setApprenti(apprentissage);
                            fiche.setStatut(statut);
                            fiche.setEtape(etape);
                            fiche.setPromotion(promotion);
                            repoF.updateOne(fiche);
                            user.setIdParcours(repoP.findOne(nomParcours).getId());
                            repoUser.updateOne(user);
                            userFound=1;
                            break;
                        }
                    }

                }
if (userFound==1){break;}
            }//endFOR


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }

}
