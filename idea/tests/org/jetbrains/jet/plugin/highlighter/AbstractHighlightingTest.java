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

package org.jetbrains.jet.plugin.highlighter;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.InTextDirectivesUtils;
import org.jetbrains.jet.plugin.JetLightProjectDescriptor;

import java.io.File;

public abstract class AbstractHighlightingTest extends LightCodeInsightFixtureTestCase {
    @NotNull
    @Override
    protected LightProjectDescriptor getProjectDescriptor() {
        return JetLightProjectDescriptor.INSTANCE;
    }

    protected void doTest(String filePath) throws Exception {
        String fileText = FileUtil.loadFile(new File(filePath), true);
        boolean checkInfos = !InTextDirectivesUtils.isDirectiveDefined(fileText, "// NO_CHECK_INFOS");
        boolean checkWeakWarnings = !InTextDirectivesUtils.isDirectiveDefined(fileText, "// NO_CHECK_WEAK_WARNINGS");
        boolean checkWarnings = !InTextDirectivesUtils.isDirectiveDefined(fileText, "// NO_CHECK_WARNINGS");

        myFixture.configureByFile(filePath);
        myFixture.checkHighlighting(checkWarnings, checkInfos, checkWeakWarnings);
    }

    @NotNull
    @Override
    protected String getTestDataPath() {
        return "";
    }
}