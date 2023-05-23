package jp.ac.hec.cm0107.android207;

public class Student {
    private String id;
    private String name;
    private int age;
    private boolean hasOCJP;
    private String like;
    private String food;
    private String game;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasOCJP() {
        return hasOCJP;
    }

    public void setHasOCJP(boolean hasOCJP) {
        this.hasOCJP = hasOCJP;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    private String hp;
}

