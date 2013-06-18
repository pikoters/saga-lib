/*
 * Copyright 2013 Stefan Domnanovits
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codebullets.sagalib.startup;

import com.codebullets.sagalib.MessageStream;
import com.codebullets.sagalib.processing.SagaProviderFactory;
import com.codebullets.sagalib.storage.StateStorage;

/**
 * Configures and builds a new saga event stream.
 */
public interface StreamBuilder {
    /**
     * Creates a new message stream instance.
     */
    MessageStream build();

    /**
     * Optional: Sets the type scanner to use. If not set the saga lib
     * will check the whole class path for implementations of sagas.
     * @param scanner The saga type scanner to use.
     */
    StreamBuilder usingScanner(TypeScanner scanner);

    /**
     * Optional: Sets the storage interface used to save and retrieve the saga state instance.
     * If not set all states will be stored in local memory.
     * @param storage The storage engine to use.
     */
    StreamBuilder usingStorage(StateStorage storage);

    /**
     * Must be set. A factory returning JSR-330 providers for saga instances.
     * The returned sagas are expected to be new instances all the time. The state
     * of a saga is attached to the instance and as such not thread safe. To avoid
     * this it is best to always return a new instance if you are not absolutely sure
     * the sagas are always handled from the same thread.
     */
    StreamBuilder usingSagaProviderFactory(SagaProviderFactory providerFactory);
}
