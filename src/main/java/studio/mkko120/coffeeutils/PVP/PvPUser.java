package studio.mkko120.coffeeutils.PVP;

public class PvPUser {

    private String name;
    private Integer kills;
    private Integer deaths;
    private float kdr;

    public PvPUser(String name) {
        this.name = name;
        this.kills = 0;
        this.deaths = 0;
        this.kdr = 0.0f;
    }

    public PvPUser(String name, Integer kills, Integer deaths) {
        this.name = name;
        this.kills = kills;
        this.deaths = deaths;
        this.kdr = getKDR();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }
    
    public float getKDR() {
        if (this.deaths != 0) {
            return (float)this.kills / this.deaths;
        } else {
            return this.kills;
        }
    }
}
