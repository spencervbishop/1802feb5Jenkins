package com.inheritance;

public class Inheritance {
    public static void main(String[] args) {
        //Object j = new Jedi();
        //j. notice we don't have access to anything, here Object is the super class and j can point to anything

        //j = new Runnable(){
        //public void run () {
        //}
        //};

        //Jedi m = new Jedi();
        //m. now we can

        //((Jedi)j). and now we can also "cast"

//        Object[] objs = new Object[3];   MUST TYPE CHECK IF YOU WANNA DO THIS
//
//        objs[0] = 1;
//        objs[1] = "Hello world.";
//        objs[2] = new Padawan();

        Jedi p = new Padawan();
        Jedi k = new JediKnight();
        Jedi m = new JediMaster();

        p.setlightsaberColor(null);
        ((Padawan)p).setMaster(k); //temporary

        //k.getMissionName();  doesnt work
        JediKnight t = (JediKnight)k;  //permanent
        t.getMissionName();

        ((JediKnight)k).setMissionName("mission 1");
        t.setMissionName("mission 2");

        System.out.println(((JediKnight)k).getMissionName());
        System.out.println(t.getMissionName());             //prints the same thing becuase ((JediKnight)k)
                                                            // and t point to a JediKnight
        roleCall(p);
        roleCall(k);
        roleCall(m);

//        missionReport(p);     these dont work because you cant cast these to a Jedi knight
//        missionReport(k);
//        missionReport(m);
        missionReport(t);


        }
    public static void roleCall(Jedi jed){
        System.out.println(jed.getName());

    }
    public static void missionReport(JediKnight jed){
        System.out.println(jed.getMissionName());
    }
}
