/*
 * Copyright 2014 Matthew Collins
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.thinkofdeath.thinkcraft.html.shared;

import com.google.gwt.core.client.JavaScriptObject;
import uk.co.thinkofdeath.thinkcraft.shared.Texture;

public class TextureMap extends JavaScriptObject {
    protected TextureMap() {
    }

    public final native int getNumberOfImages()/*-{
        return this.textureImages;
    }-*/;

    public final native void forEach(Looper looper)/*-{
        for (key in this.textures) {
            if (this.textures.hasOwnProperty(key)) {
                var texture = this.textures[key];
                looper.@uk.co.thinkofdeath.thinkcraft.html.shared.TextureMap.Looper::forEach(Ljava/lang/String;Luk/co/thinkofdeath/thinkcraft/shared/Texture;)(
                    key,
                    new @uk.co.thinkofdeath.thinkcraft.shared.Texture::new(Ljava/lang/String;IIIII)(
                        key,
                        texture.posX,
                        texture.posY,
                        texture.size,
                        texture.width,
                        texture.frames
                    ));
            }
        }
    }-*/;

    public static interface Looper {
        void forEach(String k, Texture v);
    }

}