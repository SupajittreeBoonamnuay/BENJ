package sut.game01.core.Screen;

import playn.core.Font;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.util.Callback;
import react.UnitSlot;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;
import tripleplay.ui.*;
import tripleplay.ui.Root;
import static playn.core.PlayN.graphics;
import static tripleplay.ui.SimpleStyles.newSheet;
import static tripleplay.ui.layout.AxisLayout.vertical;

/**
 * Created by supercell on 1/21/14.
 */
public class Homescreen extends UIScreen{

    public static final Font TITLE_FONT =
            graphics().createFont(
              "Helvetica",
               Font.Style.BOLD,24
            );
private final ScreenStack ss;
private Root root;
public Homescreen(ScreenStack ss){
    this.ss=ss;
}
    @Override
    public void wasAdded(){
        super.wasAdded();
        Image bgImage = PlayN.assets().getImage("images/bg.png");
        bgImage.addCallback(new Callback<Image>(){
            @Override
            public void onSuccess(Image result){

            }
            @Override
            public void onFailure(Throwable cause){

            }
        });
        ImageLayer bgLayer = PlayN.graphics().createImageLayer(bgImage);
        layer.add(bgLayer);

    }

    @Override
    public void wasShown() {

        super.wasShown();
        root = iface.createRoot(
                vertical().gap(15),
                newSheet(), layer);
        root.setSize(width(), height());
        root.add(new Label("Intouch Sawasdee")
            .addStyles(Style.FONT.is(Homescreen.TITLE_FONT)));

        root.add(new Button("จิ้มๆ").onClick(new UnitSlot(){
            public void onEmit(){
                ss.push(new TestScreen(ss));
            }
        }));
    }
}
