package com.intern.mallika.recycle;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Mallika on 1/23/2018.
 */

public class Contact {
    private String name,god;
    private String image;

    public Contact(String image,String name,String god) {

        this.setGod(god);
        this.setImage(image);
        this.setName(name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGod() {
        return god;
    }

    public void setGod(String god) {
        this.god = god;
    }

}
