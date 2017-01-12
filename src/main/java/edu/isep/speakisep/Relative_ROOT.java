package edu.isep.speakisep;

public  class Relative_ROOT {
    private Class myClass = getClass();
    public String imagePath = getBASE_ROOT();



    private String getLoaderRessource() {
        try {
            ClassLoader loader = myClass.getClassLoader();
            imagePath = loader.getResource("").getPath();
            System.out.println("éthis :"+imagePath);

        } catch (Exception e) {

        }
        return imagePath;
    }

    private String dispatcher(String path) {
        int len = path.lastIndexOf("rose_persan_vif");
        if (len!=-1){
            path = path.substring(0, len)+"rose_persan_vif/";

        } else if(path.lastIndexOf("apache-tomcat")!=-1){
            path = "/Users/Frost_000/code/isep/speakIsep/rose_persan_vif/";
        }else {
            path = "/Users/SophieTonnoir/GitHub/rose_persan_vif5/";
        }
        return path;

    }

    private String getBASE_ROOT() {
        String aa=getLoaderRessource();
        return  dispatcher(aa);
    }

    public String addRoot(String path){
        String absolutePath=this.imagePath+path;
    return absolutePath;}

}
