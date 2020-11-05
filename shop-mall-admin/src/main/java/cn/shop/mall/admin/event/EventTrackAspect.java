package cn.shop.mall.admin.event;

import cn.shop.mall.admin.service.EventTrackService;
import cn.shop.mall.common.enums.EventSourceEnum;
import cn.shop.mall.common.enums.EventTrackEnum;
import cn.shop.mall.common.model.CurrentAuthorization;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class EventTrackAspect {

    @Autowired
    private EventTrackService eventTrackService;

    @Value("version")
    private String version;

    @Pointcut("@annotation(cn.shop.mall.admin.event.EventTrack)")
    public void eventPointCut() {
    }

    @AfterReturning(value = "eventPointCut()")
    public void doEventTrack(JoinPoint joinPoint) {
        String userName = CurrentAuthorization.getUserName();
        EventSourceEnum eventSource = EventSourceEnum.服务端;
        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在的方法
        Method method = signature.getMethod();
        EventTrack eventTrack = method.getAnnotation(EventTrack.class);
        EventTrackEnum eventTrackEnum = eventTrack.value();
        eventTrackService.save(eventSource.getTag(), userName, eventTrackEnum.getTag(), version, eventTrackEnum.getMsg());
    }
}
