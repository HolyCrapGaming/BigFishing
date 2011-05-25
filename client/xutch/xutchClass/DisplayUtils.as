package xutch.xutchClass {
	import com.matrixjoy.game.common.log.Log;

	import flash.display.DisplayObject;
	import flash.display.DisplayObjectContainer;
	import flash.display.Shape;
	import flash.display.Sprite;

	//import ge.interfaces.IGeComponent;
	//import ge.interfaces.IGeContainer;


	public class DisplayObjUtils {

		public function DisplayObjUtils() {
		}

		//public static const BG_CHILD_NAME:String = "ge_internal::geSpriteBg";
		/**
		 *
		 * @param t
		 *
		 */
		public static function removeSelf(t : DisplayObject) : void {
			if (t) {
				if (t.parent) {
					t.parent.removeChild(t);
				}
			}
		}

		public static function removeAllChildren(container : DisplayObjectContainer) : void {
			while (container.numChildren > 0) {
				container.removeChildAt(0);
			}
		}

		public static function getSelfIndex(t : DisplayObject) : int {
			if (t.parent) {
				return t.parent.getChildIndex(t);
			}
			return 0;
		}

		/**
		 * 递归停止所有MC,有性能消耗
		 * @param dObj
		 * @param includeSelf
		 * @return
		 */
		public static function stopAllMovie(dObj : *) : void {
			try {
				var tempBool : Boolean = dObj.hasOwnProperty("numChildren")
				if (tempBool) {
					var num : uint = dObj.numChildren;
					for (var j : int = num - 1; j >= 0; j--) {
						var temp : * = dObj.getChildAt(j);
						try {
							stopAllMovie(temp);
						} catch (e : *) {
							trace("clear Error");
							continue;
						}
					}
				}
			} catch (e : *) {
			}
			try {
				dObj.stop();
			} catch (e : *) {
			}
		}

		/**
		 * 递归播放所有MC,有性能消耗
		 * @param dObj
		 * @param includeSelf
		 * @return
		 */
		public static function playAllMovie(dObj : *) : void {
			try {
				var tempBool : Boolean = dObj.hasOwnProperty("numChildren")
				if (tempBool) {
					var num : uint = dObj.numChildren;
					for (var j : int = num - 1; j >= 0; j--) {
						var temp : * = dObj.getChildAt(j);
						try {
							playAllMovie(temp);
						} catch (e : *) {
							trace("clear Error");
							continue;
						}
					}
				}
			} catch (e : *) {
			}
			try {
				dObj.play();
			} catch (e : *) {
			}
		}

		/**
		 *
		 * @param t
		 * @param bg
		 *
		 */
		public static function addBgAssets(t : DisplayObjectContainer, bg : DisplayObject) : void {
		/*var oldBg:DisplayObject = t.getChildByName( BG_CHILD_NAME );
		   if( oldBg ){
		   t.removeChild( oldBg );
		   }
		   if( t is IGeContainer ){
		   ( t as IGeContainer ).backgroundChild = bg;
		   return;
		   }else{
		   try{
		   bg.name = BG_CHILD_NAME;
		   }catch( e:Error ){
		   Log.error( "addBgAssets::" + e.message );
		   return;
		   }
		   t.addChildAt( bg, 0 );
		 }*/
		}

		/**
		 *
		 * @param t
		 * @return
		 *
		 */
		public static function getNumChildrenExceptBg(t : DisplayObjectContainer) : int {
			var num : int = t.numChildren;
			/*if( t is IGeComponent ){
			   if( ( t as IGeContainer ).backgroundChild ){
			   return --num;
			   }else if( t.getChildByName( BG_CHILD_NAME ) ){
			   return --num;
			   }
			 }*/
			return num;
		}

		/**
		 *
		 * @return
		 *
		 */
		public static function createPoint() : Shape {
			var s : Shape = new Shape();
			s.graphics.beginFill(0);
			s.graphics.drawRect(0, 0, 1, 1);
			s.graphics.endFill();
			return s;
		}

		/**
		 *
		 * @param c
		 * @param hmargin
		 * @param vmargin
		 *
		 */
		public static function extendBg(c : DisplayObjectContainer, hmargin : int = 0, vmargin : int = 0) : void {
		/*var bg:DisplayObject = c.getChildByName( BG_CHILD_NAME );
		   if( bg == null ){
		   Log.warn( "no bg extend" );
		   }else{
		   c.removeChild( bg );
		   bg.width = c.width + 2 * hmargin;
		   bg.height = c.height + 2 * vmargin;
		   addBgAssets( c, bg );
		 }*/
		}

		/**
		 *
		 * @return
		 *
		 */
		public static function isBg(t : DisplayObject) : Boolean {
			return false;
			//return t.name == BG_CHILD_NAME;
		}

		/**
		 *
		 * @param c
		 * @param t
		 * @return
		 *
		 */
		public static function isMask(c : DisplayObjectContainer, t : DisplayObject) : Boolean {
			if (c.mask == null)
				return false;
			return c.mask == t;
		}
	}
}