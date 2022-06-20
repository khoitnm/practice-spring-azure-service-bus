package org.tnmk.practicespringjpa.pro00simpleconnect.testinfra;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.tnmk.practicespringjpa.pro00simpleconnect.Pro00SimpleConnectApplication;

@ActiveProfiles("test")
@SpringBootTest(classes = { Pro00SimpleConnectApplication.class })
public abstract class BaseSpringTest {
}
