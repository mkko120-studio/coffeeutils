package studio.mkko120.coffeeutils.PAPI;

import studio.mkko120.coffeeutils.PVP.PvPUser;
import studio.mkko120.coffeeutils.UTIL.Loaders;

import java.util.ArrayList;

public class PapiFormatter {

    public static String topKDR() {
        StringBuilder topKDR = new StringBuilder();
        ArrayList<PvPUser> all = new ArrayList<>(Loaders.getInstances().values());
        ArrayList<PvPUser> top10 = new ArrayList<>();

        for (PvPUser user : all) {
            if (!top10.contains(user)) {
                if (top10.size() <=10 ) {
                    top10.add(user);
                } else {
                    int i = Math.min(all.size(), 10);
                    while (i > 0) {
                        if (user.getKDR() > top10.get(i).getKDR()) {
                            PvPUser tempuser = top10.get(i);
                            for (int i1 = i; i1 <= 9; i1++) {
                                PvPUser tempuser2 = top10.get(i1+1);
                                if (tempuser2 == tempuser) {
                                    top10.set(i1 + 1, tempuser);
                                } else {
                                    top10.set(i1 + 1, tempuser2);
                                }
                            }
                            top10.set(i, user);
                            break;
                        }
                        i--;
                    }
                }
            }
        }

        topKDR.append("Najlepsze KDR:\n");
        for (int i = 0; i < 10; i++) {
            PvPUser user = top10.get(i);
            topKDR.append(i).append(". ").append(user.getName()).append(": KDR: ").append(user.getKDR()).append("\n");
        }


        return topKDR.toString();

    }

    public static String topDeaths() {
        StringBuilder topdeaths = new StringBuilder();
        ArrayList<PvPUser> all = new ArrayList<>(Loaders.getInstances().values());
        ArrayList<PvPUser> top10 = new ArrayList<>();

        for (PvPUser user : all) {
            if (!top10.contains(user)) {
                if (top10.size() <=10 ) {
                    top10.add(user);
                } else {
                    int i = Math.min(all.size(), 10);
                    while (i > 0) {
                        if (user.getDeaths() > top10.get(i).getDeaths()) {
                            PvPUser tempuser = top10.get(i);
                            for (int i1 = i; i1 < 10; i1++) {
                                PvPUser tempuser2 = top10.get(i1+1);
                                if (tempuser2 == tempuser) {
                                    top10.set(i1 + 1, tempuser);
                                } else {
                                    top10.set(i1 + 1, tempuser2);
                                }
                            }
                            top10.set(i, user);
                            break;
                        }
                        i--;
                    }
                }
            }
        }

        topdeaths.append("Najwięcej śmierci:\n");
        for (int i = 0; i < 10; i++) {
            PvPUser user = top10.get(i);
            topdeaths.append(i).append(". ").append(user.getName()).append(": Smierci: ").append(user.getDeaths()).append("\n");
        }


        return topdeaths.toString();
    }

    public static String topKills() {
        StringBuilder topKills = new StringBuilder();
        ArrayList<PvPUser> all =  new ArrayList<>(Loaders.getInstances().values());
        ArrayList<PvPUser> top10 = new ArrayList<>();

        for (PvPUser user : all) {
            if (!top10.contains(user)) {
                if (top10.size() <=10 ) {
                    top10.add(user);
                } else {
                    int i = Math.min(all.size(), 10);
                    while (i > 0) {
                        if (user.getKills() > top10.get(i).getKills()) {
                            PvPUser tempuser = top10.get(i);
                            for (int i1 = i; i1 < 10; i1++) {
                                PvPUser tempuser2 = top10.get(i1+1);
                                if (tempuser2 == tempuser) {
                                    top10.set(i1 + 1, tempuser);
                                } else {
                                    top10.set(i1 + 1, tempuser2);
                                }
                            }
                            top10.set(i, user);
                            break;
                        }
                        i--;
                    }
                }
            }
        }

        topKills.append("Najwięcej zabójstw:\n");
        for (int i = 0; i < 10; i++) {
            PvPUser user = top10.get(i);
            topKills.append(i).append(". ").append(user.getName()).append(": Zabojstwa: ").append(user.getKills()).append("\n");
        }


        return topKills.toString();

    }
}
