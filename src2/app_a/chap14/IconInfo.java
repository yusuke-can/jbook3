package app_a.chap14;

import java.awt.Image;

public interface IconInfo {
    Image getIcon(int iconType);
    int ICON_16x16 = 1;
    int ICON_32x32 = 2;
}
