/**
 * 
 * Copyright 2008 - 2011
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * @project loon
 * @author cping
 * @email：javachenpeng@yahoo.com
 * @version 0.1
 */
package loon.core.graphics.component;


public class CollisionPointQuery implements CollisionQuery {

	private float x;

	private float y;

	private Class<?> cls;

	public void init(float x, float y, Class<?> cls) {
		this.x = x;
		this.y = y;
		this.cls = cls;
	}

	@Override
	public boolean checkCollision(Actor actor) {
		return this.cls != null && !this.cls.isInstance(actor) ? false : actor
				.containsPoint(this.x, this.y);
	}
}
