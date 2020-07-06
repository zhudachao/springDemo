package com.keven.springDemo.shiro;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.keven.springDemo.model.Permission;
import com.keven.springDemo.model.Role;
import com.keven.springDemo.model.User;
import com.keven.springDemo.service.UserService;

public class MyShiroRealm extends AuthorizingRealm {
	
	 @Autowired
	    private UserService userService;

	    //shiro的权限信息配置
	    @Override
	    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	        String uid = (String) principals.getPrimaryPrincipal();
	        List<Role> roles = userService.findRoles(Integer.valueOf(uid));
	        Set<String> roleNames = new HashSet<>(roles.size());
	        for (Role role : roles) {
	            roleNames.add(role.getRole());
	        }
	        //此处把当前subject对应的所有角色信息交给shiro，调用hasRole的时候就根据这些role信息判断
	        authorizationInfo.setRoles(roleNames);
	        List<Permission> permissions = userService.findPermissions(Integer.valueOf(uid));
	        Set<String> permissionNames = new HashSet<>(permissions.size());
	        for (Permission permission : permissions) {
	            permissionNames.add(permission.getName());
	        }
	        //此处把当前subject对应的权限信息交给shiro，当调用hasPermission的时候就会根据这些信息判断
	        authorizationInfo.setStringPermissions(permissionNames);
	        return authorizationInfo;
	    }

	    //根据token获取认证信息authenticationInfo
	    @Override
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	        /**这里为什么是String类型呢？其实要根据Subject.login(token)时候的token来的，你token定义成的pricipal是啥，这里get的时候就是啥。比如我
	        Subject subject = SecurityUtils.getSubject();
	        UsernamePasswordToken idEmail = new UsernamePasswordToken(String.valueOf(user.getId()), user.getEmail());
	        try {
	            idEmail.setRememberMe(true);
	            subject.login(idEmail);
	        }
	        **/
	    	UsernamePasswordToken upwdToken = (UsernamePasswordToken) token;
	    	String name = upwdToken.getUsername();
	    	String password = String.valueOf(upwdToken.getPassword());
	    	
	    	//从数据库中根据登陆名name获取所有的用户
	       User user = (User) userService.findUsersByNameAndPWD(name, password);
	     if(null!=user) {
	    	 throw new AccountException("账号或密码错误!");
	     }else if(user.getState()==0){
	    	 throw new DisabledAccountException("账号已被禁用！");
	     }else {
	    	 user.setLastLoginTime(new Date());
	 		 userService.updateUserInfo(user);
	     }
	    	
	    	
//	        String uId = (String) token.getPrincipal();
//	        User user = userService.findUserById(uId);
//	        if (user == null) {
//	            return null;
//	        }
//	        //SimpleAuthenticationInfo还有其他构造方法，比如密码加密算法等，感兴趣可以自己看
//	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//	        		uId,  //表示凭证，可以随便设，跟token里的一致就行
//	                user.getPassword(),   //表示密钥如密码，你可以自己随便设，跟token里的一致就行
//	                getName()
//	        );
	        //authenticationInfo信息交个shiro，调用login的时候会自动比较这里的token和authenticationInfo
	        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
	    }

}
