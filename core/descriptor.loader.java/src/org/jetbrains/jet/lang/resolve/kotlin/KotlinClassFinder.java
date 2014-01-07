/*
 * Copyright 2010-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.lang.resolve.kotlin;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jet.lang.resolve.name.FqName;

public interface KotlinClassFinder {

    class SERVICE {
        @NotNull
        public static KotlinClassFinder getInstance(@NotNull Project project) {
            return ServiceManager.getService(project, KotlinClassFinder.class);
        }
    }

    @Nullable
    KotlinJvmBinaryClass findKotlinClass(@NotNull FqName fqName);

    @NotNull
    KotlinJvmBinaryClass createKotlinClass(@NotNull VirtualFile virtualFile);
}
