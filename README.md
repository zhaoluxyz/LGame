## Loon Game Engine

![LGame](https://raw.github.com/cping/LGame/master/engine_logo.png "engine_logo")

[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

[免费的游戏素材可见此](https://github.com/cping/LGame/blob/master/dev-res/README.md "Game Source of Free")

*2019年复活继续更新 - 2019-03-08。

*LGame目前版本虽然基于标准OpenGLES API开发,但项目0.1版最早脱胎于AWT Java2D时代,所以采用了AWT Graphics2D的坐标系（画布左上角为原点(x=0,y=0),Y轴向下为正值,与JavaFx或Android,JavaScript的Canvas渲染坐标一致），渲染接口也都被保存下来，Graphics2D以及Android Canvas的大部分API可以在GLEx这一全局渲染类中直接使用，甚至连J2ME时代的游戏你都能无缝移植过来(有完整API支持)。

*LGame在设计上追求一切从简，能自己实现的，绝不依赖第三方类库(One jar)，所以无论是XML或Json解析，TMX地图构建，物理引擎，游戏脚本，抑或二维码构建，都有自己的完整实现（当然，肯定也允许使用第三方的），并且能自然和游戏组件绑定。所以学习难度低(很多事情后台都自动做了)，上手容易，堪称学习难度最低的Java游戏引擎，没有之一。

*支持多语言开发，LGame同时支持Java、C#、C++等多种语言，并且可以让Java语法向其它版本自动转化，能满足任意环境的语言需求。

*有完善的组件库支持，时间轴动画，缓动、UI系统、粒子动画、物理系统等并且针对不同游戏特性开发都能在引擎中得到满足，无论是ACT，RPG或者AVG(Galgame)游戏都可以直接套用现成组件构建，最简化你的代码和工作时间。

*目前的0.5版已经初步可用，引擎代码开源并托管到github，引擎本身及其素材全部免费使用，包括商用。

*关于项目进度 - 2019-04-20。

0.5版功能大体上就是目前这些，api和功能已经基本定型，再添加就是后续0.6版的事情，另外还有一个正在写的json布局器，通过json设置的方式构建组件与精灵之类，然后直接渲染到屏幕上，并借助脚本进行游戏操作，不过0.5版也就是添加基本功能，完善要等0.6版。目前0.5这个版本最主要的目标是跨平台移植，多语言支持以及查bug补bug，功能(API)的完善已经不在此版本计划中。

等我把C#版和C++版按照Java重写一遍，然后借此再查几回bug，基本就可以发布0.5正式版了。

而0.5版后续的0.6版，主要会围绕三个方面展开：

1：多语言，多平台，多机种适配，主要是搞各大游戏机。

2：json布局器结合ioc控制反转，让游戏逻辑与变量，功能视图化，借此拖拽式生成游戏，以及可视化编辑器的开发。

2：还有就是一些效果上的优化，例如减少内存占用，更多的音频和图像格式支持，构建Shader效果库，为精灵加入脏矩渲染之类，也都是后面的事情，不可能一个版本就完成所有事情，总要分个主次的。
_________

源自中國本土的Java遊戲引擎項目

International Entertainment Machines

## Loon
formal name : Loon

A fast, simple & powerful game framework, powered by Java (also supports C# and C++).

LGame Project Restart,The game's just started.

## Features
LGame(LoonGame) is a very cool and small game library designed to simplify the complex and shorten the tedious for beginners and veterans alike. With it, you can use the best aspects of OpenGL/OpenGLES in an easy and organized way optimized for game programming. It is built around the concept that beginners should be able to start with the basics and then move up into a more complex plane of development with the veterans, all on the same platform.

LGame puts all of its effort into keeping things short and simple. The initial setup of a game consists only of making a single class; then you are done. The interface is entirely documented for easy and fast learning, so once you are started, there is nothing between you and your killer game but coding and creativity.

LGame is built around the users wishes, so do not hesitate to suggest and critique!

### Games Code Samples

![LGame](https://raw.github.com/cping/LGame/master/sample.png "samples")

[Samples](https://github.com/cping/LGame/tree/master/Java/samples "Game Sample")

[Examples](https://github.com/cping/LGame/tree/master/Java/Examples "Game Example")

### Game Run the Example(JavaSE)
```java

package org.test;

import loon.LSetting;
import loon.LazyLoading;
import loon.Screen;
import loon.javase.Loon;

public class Main  {

	public static void main(String[] args) {
		LSetting setting = new LSetting();
		//是否显示基础的debug数据(内存，精灵，桌面组件等使用情况)
		setting.isDebug = true;
		//是否显示log数据到窗体
		setting.isDisplayLog = false;
		//是否显示初始logo
		setting.isLogo = false;
		// 初始化页面用logo
		setting.logoPath = "loon_logo.png";
		// 原始大小
		setting.width = 480;
		setting.height = 320;
		// 缩放为
		setting.width_zoom = 640;
		setting.height_zoom = 480;
		//帧率
		setting.fps = 60;
		//字体
		setting.fontName = "黑体";
		//应用名
		setting.appName = "test";
		//是否模拟触屏事件（仅桌面有效）
		setting.emulateTouch = false;
		/*
		 * 设置全局IFont字体为BMFont字体,fnt和png文件默认使用loon的jar中自带<br>
		 * (不填写时默认使用内置的LFont贴图，用户也可以自定义IFont字体)<br>*/
		//setting.setSystemGameFont(BMFont.getDefaultFont());
		Loon.register(setting, new LazyLoading.Data() {

			@Override
			public Screen onScreen() {
				return new YourScreen();
			}
		});
	}
}
```
## Create a LGame project

LGame comes with a file called LGameProjectMake.jar which is an executable UI and command line tool. You can simply execute the JAR file which will open the setup UI.


![LGame](https://raw.github.com/cping/LGame/master/install.png "install")

Built-in over 30 game example(Part screenshots):

![LGame](https://raw.github.com/cping/LGame/master/e0x.png "0")

![LGame](https://raw.github.com/cping/LGame/master/e1x.png "1")

![LGame](https://raw.github.com/cping/LGame/master/e2x.png "2")

![LGame](https://raw.github.com/cping/LGame/master/e3x.png "3")

![LGame](https://raw.github.com/cping/LGame/master/e4x.png "4")

![LGame](https://raw.github.com/cping/LGame/master/live2dsupport.png "live2d_support")

License : http://www.apache.org/licenses/LICENSE-2.0

## Source Files
```
src
├── assets
│   ├── loon_bar.png
│   ├── loon_control_base.png
│   ├── loon_control_dot.png
│   ├── loon_creese.png
│   ├── loon_deffont.png
│   ├── loon_deffont.txt
│   ├── loon_e1.png
│   ├── loon_e2.png
│   ├── loon_logo.png
│   ├── loon_natural.png
│   ├── loon_natural.txt
│   ├── loon_pad_ui.png
│   ├── loon_pad_ui.txt
│   ├── loon_par.png
│   ├── loon_ui.png
│   └── loon_wbar.png
├── loon
│   ├── Accelerometer.java
│   ├── AccelerometerDefault.java
│   ├── AccelerometerState.java
│   ├── action
│   │   ├── ActionBind.java
│   │   ├── ActionCallback.java
│   │   ├── ActionControl.java
│   │   ├── ActionEvent.java
│   │   ├── ActionLinear.java
│   │   ├── ActionListener.java
│   │   ├── ActionMode.java
│   │   ├── ActionPath.java
│   │   ├── Actions.java
│   │   ├── ActionScript.java
│   │   ├── ActionSmooth.java
│   │   ├── ActionTween.java
│   │   ├── ActionTweenBase.java
│   │   ├── ActionTweenPool.java
│   │   ├── ActionType.java
│   │   ├── ArrowTo.java
│   │   ├── avg
│   │   │   ├── AVGAnm.java
│   │   │   ├── AVGCG.java
│   │   │   ├── AVGChara.java
│   │   │   ├── AVGDialog.java
│   │   │   ├── AVGScreen.java
│   │   │   └── drama
│   │   │       ├── Command.java
│   │   │       ├── CommandLink.java
│   │   │       ├── CommandType.java
│   │   │       ├── Conversion.java
│   │   │       ├── DefScriptLog.java
│   │   │       ├── Expression.java
│   │   │       ├── IMacros.java
│   │   │       ├── IRocFunction.java
│   │   │       ├── IScriptLog.java
│   │   │       ├── RocFunctions.java
│   │   │       ├── RocScript.java
│   │   │       └── RocSSprite.java
│   │   ├── BezierBy.java
│   │   ├── BezierTo.java
│   │   ├── camera
│   │   │   ├── BaseCamera.java
│   │   │   ├── EmptyCamera.java
│   │   │   ├── FPSCamera.java
│   │   │   ├── OrthographicCamera.java
│   │   │   └── PerspectiveCamera.java
│   │   ├── CircleTo.java
│   │   ├── collision
│   │   │   ├── BSPCollisionChecker.java
│   │   │   ├── BSPCollisionNode.java
│   │   │   ├── CollisionBaseQuery.java
│   │   │   ├── CollisionChecker.java
│   │   │   ├── CollisionClassQuery.java
│   │   │   ├── CollisionHelper.java
│   │   │   ├── CollisionInRangeQuery.java
│   │   │   ├── CollisionManager.java
│   │   │   ├── CollisionMask.java
│   │   │   ├── CollisionNeighbourQuery.java
│   │   │   ├── CollisionNode.java
│   │   │   ├── CollisionObject.java
│   │   │   ├── CollisionPointQuery.java
│   │   │   ├── CollisionQuery.java
│   │   │   ├── Gravity.java
│   │   │   ├── GravityHandler.java
│   │   │   ├── GravityResult.java
│   │   │   └── Hitbox.java
│   │   ├── ColorTo.java
│   │   ├── DelayTo.java
│   │   ├── EffectTo.java
│   │   ├── EventTo.java
│   │   ├── FadeTo.java
│   │   ├── FireTo.java
│   │   ├── FlashTo.java
│   │   ├── FlipXTo.java
│   │   ├── FlipYTo.java
│   │   ├── JumpTo.java
│   │   ├── map
│   │   │   ├── AStarFinder.java
│   │   │   ├── AStarFinderListener.java
│   │   │   ├── AStarFinderPool.java
│   │   │   ├── AStarFindHeuristic.java
│   │   │   ├── Attribute.java
│   │   │   ├── battle
│   │   │   │   ├── BattleAction.java
│   │   │   │   ├── BattleActive.java
│   │   │   │   ├── BattleActiveManager.java
│   │   │   │   ├── BattleAnimation.java
│   │   │   │   ├── BattleControl.java
│   │   │   │   ├── BattleEffect.java
│   │   │   │   ├── BattleEffectRenderer.java
│   │   │   │   ├── BattleEffectsDisplay.java
│   │   │   │   ├── BattleEffectState.java
│   │   │   │   ├── BattleHealthRenderer.java
│   │   │   │   ├── BattleLevel.java
│   │   │   │   ├── BattleRNG.java
│   │   │   │   ├── BattleSkillValue.java
│   │   │   │   ├── BattleTeam.java
│   │   │   │   ├── BattleView.java
│   │   │   │   ├── behavior
│   │   │   │   │   ├── IActor.java
│   │   │   │   │   ├── IActors.java
│   │   │   │   │   ├── IActorStatus.java
│   │   │   │   │   ├── IBattle.java
│   │   │   │   │   ├── IMove.java
│   │   │   │   │   └── RoleAction.java
│   │   │   │   └── DamagesState.java
│   │   │   ├── Character.java
│   │   │   ├── CharacterInfo.java
│   │   │   ├── CharacterValue.java
│   │   │   ├── colider
│   │   │   │   ├── HexagonalTileColider.java
│   │   │   │   ├── IsometricTileColider.java
│   │   │   │   ├── OrthogonalTileColider.java
│   │   │   │   ├── Tile.java
│   │   │   │   ├── TileColider.java
│   │   │   │   ├── TileEvent.java
│   │   │   │   ├── TileHelper.java
│   │   │   │   ├── TileImpl.java
│   │   │   │   ├── TileImplPathFind.java
│   │   │   │   └── TileManager.java
│   │   │   ├── Config.java
│   │   │   ├── Field2D.java
│   │   │   ├── heuristics
│   │   │   │   ├── Closest.java
│   │   │   │   ├── ClosestSquared.java
│   │   │   │   ├── Diagonal.java
│   │   │   │   ├── DiagonalShort.java
│   │   │   │   ├── Euclidean.java
│   │   │   │   ├── EuclideanNoSQR.java
│   │   │   │   ├── Manhattan.java
│   │   │   │   └── Mixing.java
│   │   │   ├── Hexagon.java
│   │   │   ├── HexagonMap.java
│   │   │   ├── Inventory.java
│   │   │   ├── Item.java
│   │   │   ├── Story.java
│   │   │   ├── TileMap.java
│   │   │   ├── TileMapConfig.java
│   │   │   ├── TileRoom.java
│   │   │   ├── TileVisit.java
│   │   │   └── tmx
│   │   │       ├── objects
│   │   │       │   ├── TMXEllipse.java
│   │   │       │   ├── TMXObject.java
│   │   │       │   ├── TMXPoint.java
│   │   │       │   ├── TMXPolygon.java
│   │   │       │   └── TMXPolyLine.java
│   │   │       ├── renderers
│   │   │       │   ├── TMXHexagonalMapRenderer.java
│   │   │       │   ├── TMXIsometricMapRenderer.java
│   │   │       │   ├── TMXMapRenderer.java
│   │   │       │   ├── TMXOrthogonalMapRenderer.java
│   │   │       │   └── TMXStaggeredMapRenderer.java
│   │   │       ├── tiles
│   │   │       │   ├── TMXAnimationFrame.java
│   │   │       │   ├── TMXMapTile.java
│   │   │       │   ├── TMXTerrain.java
│   │   │       │   └── TMXTile.java
│   │   │       ├── TMXImage.java
│   │   │       ├── TMXImageLayer.java
│   │   │       ├── TMXMap.java
│   │   │       ├── TMXMapLayer.java
│   │   │       ├── TMXObjectLayer.java
│   │   │       ├── TMXProperties.java
│   │   │       ├── TMXTileLayer.java
│   │   │       └── TMXTileSet.java
│   │   ├── MoveBy.java
│   │   ├── MoveOvalTo.java
│   │   ├── MoveRoundTo.java
│   │   ├── MoveTo.java
│   │   ├── page
│   │   │   ├── AccordionPage.java
│   │   │   ├── BasePage.java
│   │   │   ├── BTFPage.java
│   │   │   ├── CubeInPage.java
│   │   │   ├── DepthPage.java
│   │   │   ├── FadePage.java
│   │   │   ├── RotateDownPage.java
│   │   │   ├── RotatePage.java
│   │   │   ├── RotateUpPage.java
│   │   │   ├── ScreenSwitch.java
│   │   │   ├── StackPage.java
│   │   │   ├── ZoomInPage.java
│   │   │   └── ZoomOutPage.java
│   │   ├── ParallelTo.java
│   │   ├── RemoveActionsTo.java
│   │   ├── ReplayTo.java
│   │   ├── RotateTo.java
│   │   ├── ScaleTo.java
│   │   ├── ShakeTo.java
│   │   ├── ShowTo.java
│   │   ├── sprite
│   │   │   ├── ActionObject.java
│   │   │   ├── AnimatedEntity.java
│   │   │   ├── Animation.java
│   │   │   ├── AnimationData.java
│   │   │   ├── AnimationHelper.java
│   │   │   ├── AnimationStorage.java
│   │   │   ├── Background.java
│   │   │   ├── Bullet.java
│   │   │   ├── BulletEntity.java
│   │   │   ├── CanvasPlayer.java
│   │   │   ├── ColorBackground.java
│   │   │   ├── Cycle.java
│   │   │   ├── DisplayObject.java
│   │   │   ├── effect
│   │   │   │   ├── ArcEffect.java
│   │   │   │   ├── BaseEffect.java
│   │   │   │   ├── CrossEffect.java
│   │   │   │   ├── FadeBoardEffect.java
│   │   │   │   ├── FadeDotEffect.java
│   │   │   │   ├── FadeEffect.java
│   │   │   │   ├── FadeOvalEffect.java
│   │   │   │   ├── FadeSpiralEffect.java
│   │   │   │   ├── FadeTileEffect.java
│   │   │   │   ├── IKernel.java
│   │   │   │   ├── ILightning.java
│   │   │   │   ├── LightningBolt.java
│   │   │   │   ├── LightningBranch.java
│   │   │   │   ├── LightningEffect.java
│   │   │   │   ├── LightningLine.java
│   │   │   │   ├── LightningRandom.java
│   │   │   │   ├── NaturalEffect.java
│   │   │   │   ├── OutEffect.java
│   │   │   │   ├── PetalKernel.java
│   │   │   │   ├── PixelBaseEffect.java
│   │   │   │   ├── PixelChopEffect.java
│   │   │   │   ├── PixelDarkInEffect.java
│   │   │   │   ├── PixelDarkOutEffect.java
│   │   │   │   ├── PixelSnowEffect.java
│   │   │   │   ├── PixelThunderEffect.java
│   │   │   │   ├── PixelWindEffect.java
│   │   │   │   ├── PShadowEffect.java
│   │   │   │   ├── RainKernel.java
│   │   │   │   ├── RippleEffect.java
│   │   │   │   ├── RippleKernel.java
│   │   │   │   ├── ScrollEffect.java
│   │   │   │   ├── SnowKernel.java
│   │   │   │   ├── SplitEffect.java
│   │   │   │   ├── StringEffect.java
│   │   │   │   ├── SwipeEffect.java
│   │   │   │   └── TriangleEffect.java
│   │   │   ├── Entity.java
│   │   │   ├── GifAnimation.java
│   │   │   ├── IEntity.java
│   │   │   ├── ImageBackground.java
│   │   │   ├── ISprite.java
│   │   │   ├── JumpObject.java
│   │   │   ├── MoveControl.java
│   │   │   ├── MoveObject.java
│   │   │   ├── MovieClip.java
│   │   │   ├── MovieSprite.java
│   │   │   ├── NumberSprite.java
│   │   │   ├── painting
│   │   │   │   ├── ComponentEvent.java
│   │   │   │   ├── Drawable.java
│   │   │   │   ├── DrawableEvent.java
│   │   │   │   ├── DrawableGameComponent.java
│   │   │   │   ├── DrawableScreen.java
│   │   │   │   ├── DrawableState.java
│   │   │   │   ├── GameComponent.java
│   │   │   │   ├── GameComponentCollection.java
│   │   │   │   ├── IDrawable.java
│   │   │   │   ├── IGameComponent.java
│   │   │   │   └── IUpdateable.java
│   │   │   ├── Picture.java
│   │   │   ├── Scene.java
│   │   │   ├── ScrollText.java
│   │   │   ├── ShapeEntity.java
│   │   │   ├── SimpleObject.java
│   │   │   ├── Sprite.java
│   │   │   ├── SpriteBatch.java
│   │   │   ├── SpriteBatchScreen.java
│   │   │   ├── SpriteBatchSheet.java
│   │   │   ├── SpriteControls.java
│   │   │   ├── SpriteLabel.java
│   │   │   ├── SpriteRegion.java
│   │   │   ├── Sprites.java
│   │   │   ├── SpriteSheet.java
│   │   │   ├── SpriteSheetFont.java
│   │   │   ├── SpriteToEntity.java
│   │   │   ├── StatusBar.java
│   │   │   ├── StatusBars.java
│   │   │   ├── TextureObject.java
│   │   │   └── WaitSprite.java
│   │   ├── TimeLine.java
│   │   ├── TransferTo.java
│   │   ├── TransformTo.java
│   │   ├── TweenTo.java
│   │   ├── UpdateTo.java
│   │   └── WaitTo.java
│   ├── ActionCounter.java
│   ├── Assets.java
│   ├── Asyn.java
│   ├── BaseIO.java
│   ├── canvas
│   │   ├── Alpha.java
│   │   ├── Canvas.java
│   │   ├── ConvolutionMatrix.java
│   │   ├── Gradient.java
│   │   ├── Image.java
│   │   ├── ImageImpl.java
│   │   ├── ImageNinePatch.java
│   │   ├── LColor.java
│   │   ├── LColorPool.java
│   │   ├── LGradation.java
│   │   ├── LShadow.java
│   │   ├── NinePatchAbstract.java
│   │   ├── NinePatchRegion.java
│   │   ├── Paint.java
│   │   ├── Path.java
│   │   ├── Pattern.java
│   │   ├── Pixmap.java
│   │   ├── PixmapFImpl.java
│   │   ├── PixmapNinePatch.java
│   │   ├── Row.java
│   │   └── TGA.java
│   ├── component
│   │   ├── AbstractBox.java
│   │   ├── Actor.java
│   │   ├── ActorLayer.java
│   │   ├── ActorListener.java
│   │   ├── ActorSet.java
│   │   ├── ActorTreeSet.java
│   │   ├── BaseBox.java
│   │   ├── DefUI.java
│   │   ├── Desktop.java
│   │   ├── layout
│   │   │   ├── AbsoluteLayout.java
│   │   │   ├── CenterLayout.java
│   │   │   ├── HorizontalLayout.java
│   │   │   ├── LayoutConstraints.java
│   │   │   ├── LayoutManager.java
│   │   │   ├── LayoutPort.java
│   │   │   ├── OverlayLayout.java
│   │   │   └── VerticalLayout.java
│   │   ├── LButton.java
│   │   ├── LCheckBox.java
│   │   ├── LCheckGroup.java
│   │   ├── LClickButton.java
│   │   ├── LComponent.java
│   │   ├── LContainer.java
│   │   ├── LControl.java
│   │   ├── LDecideName.java
│   │   ├── LGesture.java
│   │   ├── LLabel.java
│   │   ├── LLabels.java
│   │   ├── LLayer.java
│   │   ├── LMenu.java
│   │   ├── LMenuSelect.java
│   │   ├── LMessage.java
│   │   ├── LMessageBox.java
│   │   ├── LPad.java
│   │   ├── LPanel.java
│   │   ├── LPaper.java
│   │   ├── LProgress.java
│   │   ├── LScrollBar.java
│   │   ├── LScrollContainer.java
│   │   ├── LSelect.java
│   │   ├── LSelectorIcon.java
│   │   ├── LSlider.java
│   │   ├── LSpriteUI.java
│   │   ├── LTextArea.java
│   │   ├── LTextBar.java
│   │   ├── LTextField.java
│   │   ├── LTextList.java
│   │   ├── LTextTree.java
│   │   ├── LToast.java
│   │   ├── LToolTip.java
│   │   ├── LWindow.java
│   │   ├── Print.java
│   │   ├── skin
│   │   │   ├── CheckBoxSkin.java
│   │   │   ├── ClickButtonSkin.java
│   │   │   ├── ControlSkin.java
│   │   │   ├── MenuSkin.java
│   │   │   ├── MessageSkin.java
│   │   │   ├── ProgressSkin.java
│   │   │   ├── ScrollBarSkin.java
│   │   │   ├── SelectSkin.java
│   │   │   ├── SkinManager.java
│   │   │   ├── SliderSkin.java
│   │   │   ├── TableSkin.java
│   │   │   ├── TextAreaSkin.java
│   │   │   ├── TextBarSkin.java
│   │   │   ├── TextListSkin.java
│   │   │   ├── ToastSkin.java
│   │   │   └── WindowSkin.java
│   │   ├── table
│   │   │   ├── ICellRenderer.java
│   │   │   ├── ITableModel.java
│   │   │   ├── ListItem.java
│   │   │   ├── LTable.java
│   │   │   ├── SimpleTableModel.java
│   │   │   ├── TableColumn.java
│   │   │   ├── TableColumnLayout.java
│   │   │   ├── TableLayout.java
│   │   │   ├── TableLayoutRow.java
│   │   │   ├── TextCellRenderer.java
│   │   │   └── TextureCellRenderer.java
│   │   └── UIControls.java
│   ├── Counter.java
│   ├── Director.java
│   ├── Display.java
│   ├── EmptyBundle.java
│   ├── EmptyGame.java
│   ├── EmptyObject.java
│   ├── EmulatorButton.java
│   ├── EmulatorButtons.java
│   ├── EmulatorListener.java
│   ├── event
│   │   ├── ActionKey.java
│   │   ├── ActionUpdate.java
│   │   ├── CallFunction.java
│   │   ├── ClickListener.java
│   │   ├── DrawListener.java
│   │   ├── Event.java
│   │   ├── EventDispatcher.java
│   │   ├── FrameLoopEvent.java
│   │   ├── GameKey.java
│   │   ├── GameTouch.java
│   │   ├── IEventListener.java
│   │   ├── InputMake.java
│   │   ├── InputMakeImpl.java
│   │   ├── KeyMake.java
│   │   ├── LTouchArea.java
│   │   ├── LTouchCollection.java
│   │   ├── LTouchLocation.java
│   │   ├── LTouchLocationState.java
│   │   ├── MouseMake.java
│   │   ├── QueryEvent.java
│   │   ├── SysInput.java
│   │   ├── SysInputFactory.java
│   │   ├── SysKey.java
│   │   ├── SysTouch.java
│   │   ├── Touched.java
│   │   ├── TouchedClick.java
│   │   ├── TouchMake.java
│   │   ├── Updateable.java
│   │   └── ValueListener.java
│   ├── font
│   │   ├── AutoWrap.java
│   │   ├── BMFont.java
│   │   ├── Font.java
│   │   ├── FontSet.java
│   │   ├── FontUtils.java
│   │   ├── IFont.java
│   │   ├── LFont.java
│   │   ├── ShadowFont.java
│   │   ├── Text.java
│   │   ├── TextFormat.java
│   │   ├── TextLayout.java
│   │   ├── TextOptions.java
│   │   └── TextWrap.java
│   ├── GameType.java
│   ├── geom
│   │   ├── AABB.java
│   │   ├── Affine2f.java
│   │   ├── Alignment.java
│   │   ├── Bezier.java
│   │   ├── BooleanValue.java
│   │   ├── BoundingBox.java
│   │   ├── BoxSize.java
│   │   ├── Circle.java
│   │   ├── Curve.java
│   │   ├── Dimension.java
│   │   ├── Ellipse.java
│   │   ├── FloatValue.java
│   │   ├── IntValue.java
│   │   ├── Limit.java
│   │   ├── Line.java
│   │   ├── Matrix3.java
│   │   ├── Matrix4.java
│   │   ├── Padding.java
│   │   ├── Path.java
│   │   ├── Plane.java
│   │   ├── Point.java
│   │   ├── PointF.java
│   │   ├── PointI.java
│   │   ├── Polygon.java
│   │   ├── Quaternion.java
│   │   ├── RectBox.java
│   │   ├── RectF.java
│   │   ├── RectI.java
│   │   ├── Region.java
│   │   ├── Shape.java
│   │   ├── ShapeUtils.java
│   │   ├── SizeValue.java
│   │   ├── Transform.java
│   │   ├── Transforms.java
│   │   ├── Triangle.java
│   │   ├── Triangle2f.java
│   │   ├── TriangleBasic.java
│   │   ├── TriangleNeat.java
│   │   ├── TriangleOver.java
│   │   ├── Vector2f.java
│   │   ├── Vector3f.java
│   │   ├── Vector4f.java
│   │   └── XY.java
│   ├── Graphics.java
│   ├── HorizontalAlign.java
│   ├── IDGenerator.java
│   ├── Json.java
│   ├── LazyLoading.java
│   ├── LGame.java
│   ├── LimitedCounter.java
│   ├── LObject.java
│   ├── Log.java
│   ├── LogDisplay.java
│   ├── LProcess.java
│   ├── LRelease.java
│   ├── LSetting.java
│   ├── LSystem.java
│   ├── LSystemView.java
│   ├── LTexture.java
│   ├── LTextureBatch.java
│   ├── LTextures.java
│   ├── LTrans.java
│   ├── LTransition.java
│   ├── opengl
│   │   ├── BaseBatch.java
│   │   ├── BlendMode.java
│   │   ├── BlendState.java
│   │   ├── ExpandVertices.java
│   │   ├── GL20.java
│   │   ├── GLBase.java
│   │   ├── GLBatch.java
│   │   ├── GLEx.java
│   │   ├── GLExt.java
│   │   ├── GLPaint.java
│   │   ├── GLRenderer.java
│   │   ├── IndexArray.java
│   │   ├── IndexBufferObject.java
│   │   ├── IndexBufferObjectSubData.java
│   │   ├── IndexData.java
│   │   ├── light
│   │   │   ├── AmbientCubemap.java
│   │   │   ├── BaseLight.java
│   │   │   ├── DirectionalLight.java
│   │   │   ├── Lights.java
│   │   │   ├── LLight.java
│   │   │   └── PointLight.java
│   │   ├── LSTRDictionary.java
│   │   ├── LSTRFont.java
│   │   ├── LSubTexture.java
│   │   ├── LTextureBind.java
│   │   ├── LTextureFree.java
│   │   ├── LTextureImage.java
│   │   ├── LTexturePack.java
│   │   ├── LTexturePackClip.java
│   │   ├── LTextureRegion.java
│   │   ├── Mesh.java
│   │   ├── MeshDefault.java
│   │   ├── Painter.java
│   │   ├── PreBoxViewer3D.java
│   │   ├── RenderTarget.java
│   │   ├── ShaderCmd.java
│   │   ├── ShaderProgram.java
│   │   ├── ShaderUtils.java
│   │   ├── TextureSource.java
│   │   ├── TextureUtils.java
│   │   ├── TrilateralBatch.java
│   │   ├── VertexArray.java
│   │   ├── VertexAttribute.java
│   │   ├── VertexAttributes.java
│   │   ├── VertexBufferObject.java
│   │   ├── VertexBufferObjectSubData.java
│   │   └── VertexData.java
│   ├── particle
│   │   ├── ParticleSprite.java
│   │   ├── SimpleConfigurableEmitter.java
│   │   ├── SimpleEmitter.java
│   │   ├── SimpleFireEmitter.java
│   │   ├── SimpleParticle.java
│   │   ├── SimpleParticleConfig.java
│   │   └── SimpleParticleSystem.java
│   ├── physics
│   │   ├── PBody.java
│   │   ├── PBoxShape.java
│   │   ├── PCircleCirlceCollider.java
│   │   ├── PCirclePolygonCollider.java
│   │   ├── PCircleShape.java
│   │   ├── PCollider.java
│   │   ├── PCollisionChooser.java
│   │   ├── PConcavePolygonShape.java
│   │   ├── PContact.java
│   │   ├── PContactData.java
│   │   ├── PConvexPolygonShape.java
│   │   ├── PDragJoint.java
│   │   ├── PFigure.java
│   │   ├── PHingeJoint.java
│   │   ├── PInsertionSorter.java
│   │   ├── PJoint.java
│   │   ├── PJointType.java
│   │   ├── PPhysManager.java
│   │   ├── PPhysWorld.java
│   │   ├── PPolygon.java
│   │   ├── PPolygonDrawer.java
│   │   ├── PPolygonizer.java
│   │   ├── PPolygonPolygonCollider.java
│   │   ├── PRodJoint.java
│   │   ├── PShape.java
│   │   ├── PShapeType.java
│   │   ├── PSolver.java
│   │   ├── PSortableAABB.java
│   │   ├── PSortableObject.java
│   │   ├── PSpringJoint.java
│   │   ├── PSweepAndPrune.java
│   │   ├── PTransformer.java
│   │   ├── PTriangulator.java
│   │   ├── PVertexLoop.java
│   │   └── PWorldBox.java
│   ├── Platform.java
│   ├── PlayerUtils.java
│   ├── Save.java
│   ├── SaveBatchImpl.java
│   ├── Screen.java
│   ├── ScreenAction.java
│   ├── Session.java
│   ├── Sound.java
│   ├── SoundBox.java
│   ├── SoundImpl.java
│   ├── Stage.java
│   ├── Support.java
│   ├── utils
│   │   ├── ARC4.java
│   │   ├── Array.java
│   │   ├── ArrayByte.java
│   │   ├── ArrayByteOutput.java
│   │   ├── ArrayByteReader.java
│   │   ├── ArrayMap.java
│   │   ├── Base64Coder.java
│   │   ├── Bundle.java
│   │   ├── Calculator.java
│   │   ├── CharArray.java
│   │   ├── CharUtils.java
│   │   ├── CollectionUtils.java
│   │   ├── ConfigReader.java
│   │   ├── Easing.java
│   │   ├── Flip.java
│   │   ├── FloatArray.java
│   │   ├── GestureData.java
│   │   ├── GestureLoader.java
│   │   ├── GifDecoder.java
│   │   ├── GifEncoder.java
│   │   ├── GLUtils.java
│   │   ├── I18N.java
│   │   ├── IArray.java
│   │   ├── InsertionSorter.java
│   │   ├── IntArray.java
│   │   ├── IntMap.java
│   │   ├── json
│   │   │   ├── JsonArray.java
│   │   │   ├── JsonBuilder.java
│   │   │   ├── JsonImpl.java
│   │   │   ├── JsonObject.java
│   │   │   ├── JsonParser.java
│   │   │   ├── JsonParserException.java
│   │   │   ├── JsonSink.java
│   │   │   ├── JsonStringTypedArray.java
│   │   │   └── JsonTypes.java
│   │   ├── Language.java
│   │   ├── LayerSorter.java
│   │   ├── ListMap.java
│   │   ├── LIterator.java
│   │   ├── LongArray.java
│   │   ├── LoopStringBuilder.java
│   │   ├── MapBundle.java
│   │   ├── MathUtils.java
│   │   ├── MD5.java
│   │   ├── MessageQueue.java
│   │   ├── NumberUtils.java
│   │   ├── ObjectBundle.java
│   │   ├── ObjectMap.java
│   │   ├── ObjectSet.java
│   │   ├── OrderedMap.java
│   │   ├── OrderedSet.java
│   │   ├── ParsePythonData.java
│   │   ├── Pool.java
│   │   ├── Pools.java
│   │   ├── processes
│   │   │   ├── GameProcess.java
│   │   │   ├── ProgressCallable.java
│   │   │   ├── ProgressListener.java
│   │   │   ├── ProgressMonitor.java
│   │   │   ├── RealtimeProcess.java
│   │   │   ├── RealtimeProcessEvent.java
│   │   │   ├── RealtimeProcessHost.java
│   │   │   ├── RealtimeProcessManager.java
│   │   │   └── WaitProcess.java
│   │   ├── reflect
│   │   │   ├── Annotation.java
│   │   │   ├── ArrayReflection.java
│   │   │   ├── ClassReflection.java
│   │   │   ├── Constructor.java
│   │   │   ├── Field.java
│   │   │   ├── Method.java
│   │   │   └── ReflectionException.java
│   │   ├── RefManager.java
│   │   ├── RefObject.java
│   │   ├── reply
│   │   │   ├── AbstractAct.java
│   │   │   ├── AbstractValue.java
│   │   │   ├── Act.java
│   │   │   ├── ActView.java
│   │   │   ├── Bypass.java
│   │   │   ├── Callback.java
│   │   │   ├── CallbackList.java
│   │   │   ├── Closeable.java
│   │   │   ├── Connection.java
│   │   │   ├── Cons.java
│   │   │   ├── Function.java
│   │   │   ├── GoFuture.java
│   │   │   ├── GoPromise.java
│   │   │   ├── MappedAct.java
│   │   │   ├── MappedValue.java
│   │   │   ├── Port.java
│   │   │   ├── Try.java
│   │   │   ├── UnitPort.java
│   │   │   ├── Var.java
│   │   │   └── VarView.java
│   │   ├── res
│   │   │   ├── FontSheet.java
│   │   │   ├── MovieSpriteSheet.java
│   │   │   ├── ResourceGetter.java
│   │   │   ├── ResourceItem.java
│   │   │   ├── ResourceLocal.java
│   │   │   ├── ResourceType.java
│   │   │   ├── Texture.java
│   │   │   ├── TextureAtlas.java
│   │   │   └── TextureData.java
│   │   ├── Resolution.java
│   │   ├── Scale.java
│   │   ├── SortedList.java
│   │   ├── Sorter.java
│   │   ├── SortUtils.java
│   │   ├── StringKeyValue.java
│   │   ├── StringUtils.java
│   │   ├── TArray.java
│   │   ├── timer
│   │   │   ├── CountdownTimer.java
│   │   │   ├── EaseTimer.java
│   │   │   ├── FloatTimerEvent.java
│   │   │   ├── GameTime.java
│   │   │   ├── LTimer.java
│   │   │   ├── LTimerContext.java
│   │   │   ├── StopwatchTimer.java
│   │   │   └── TempTimer.java
│   │   ├── TimeUtils.java
│   │   ├── TreeNode.java
│   │   ├── UNByte.java
│   │   ├── UNInt.java
│   │   ├── UNLong.java
│   │   ├── UNShort.java
│   │   ├── URecognizer.java
│   │   ├── URecognizerAnalyze.java
│   │   ├── URecognizerObject.java
│   │   ├── URecognizerResult.java
│   │   ├── UUID.java
│   │   └── xml
│   │       ├── XMLAttribute.java
│   │       ├── XMLComment.java
│   │       ├── XMLData.java
│   │       ├── XMLDocument.java
│   │       ├── XMLElement.java
│   │       ├── XMLListener.java
│   │       ├── XMLOutput.java
│   │       ├── XMLParser.java
│   │       ├── XMLProcessing.java
│   │       └── XMLTokenizer.java
│   ├── VerticalAlign.java
│   ├── Visible.java
│   └── ZIndex.java
└── loon.gwt.xml

40 directories, 753 files
```

### This Java implemented game framework(but will provide a cross-compiler contain C#,C/C++,Go,JavaScript or other programming language implemented),Support IOS\Android\WP7\PSM\Mac\Windows\Linux.