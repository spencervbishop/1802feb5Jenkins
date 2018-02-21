package com.singleton.luke;

public enum LukeSkywalker {
    LUKE_SKYWALKER("Grandmaster Jedi");     //now this singleton is protected from reflection because
                                            //it can only be constructed by the JVM.

    private String title;

    LukeSkywalker(){}
    LukeSkywalker(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void loseHand(){
        System.out.println("ouch");
    }

}
