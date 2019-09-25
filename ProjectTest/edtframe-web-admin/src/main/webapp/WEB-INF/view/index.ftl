<!DOCTYPE HTML>
<html>
<head>
    <#include "common.ftl">
    <title>黑龙江一点通基础框架（标准版）</title>
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl">
            <a class="logo navbar-logo f-l mr-10 hidden-xs">黑龙江一点通基础框架（标准版）</a>
            <nav id="Hui-userbar"
                 class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li class="mr-20"><font class="c-999">所属机构：${user.mechanisms.name }</font></li>
                    <li class="mr-10"><span class="label-warning radius c_p-o5">${user.role.name }</span></li>
                    <li class="dropDown dropDown_hover"><a href="#"
                                                           class="dropDown_A">${user.name }&nbsp;<i
                            class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="#" onclick="toUserInfo('${user.id}')">个人信息</a></li>
                            <li><a href="${ctx }/user/logout" class="c-error">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <input runat="server" id="divScrollValue" type="hidden" value=""/>
    <div class="menu_dropdown bk_2 sidebar-menu">
<#--<#list listIndexRoleMenu as listMenufirst>-->
    <ul id="menu-article">
        <li>
              <a _href="redirect?page=user/user" data-title="用户管理" href="javascript:void(0)"  style="color:#f0f1f2">用户管理</a>
            <#--<i class="Hui-iconfont">&#xe616;</i> ${listMenufirst.name}<i
                class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>-->
        </li>
        <li>
            <a _href="redirect?page=role/role" data-title="角色管理" href="javascript:void(0)"  style="color:#f0f1f2">角色管理</a>
        </li>
        <li>
            <a _href="redirect?page=order/order" data-title="测试" href="javascript:void(0)"  style="color:#f0f1f2">测试</a>
        </li>
       <#-- <dd>
            <ul>
                <#list listMenufirst.listMenuChild as listMenuSecond>
                    <li>
                        <#if listMenuSecond.openUrl?? && listMenuSecond.openUrl != ''>
                            <a _href="${listMenuSecond.openUrl }" data-title="${listMenuSecond.name }"
                               href="javascript:void(0)">${listMenuSecond.name }</a>
                        <#else>
                            <a _href="${listMenuSecond.openUrl }" data-title="${listMenuSecond.name }"
                               href="javascript:void(0)">${listMenuSecond.name } <i
                                    class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></a>
                        </#if>
                        <ul class="treeview-menu">
                            <#if listMenuSecond.listMenuChild??>
                                    <#list listMenuSecond.listMenuChild as listMenuThird>
                                        <li><a _href="${ctx}/${listMenuThird.openUrl }"
                                               data-title="${listMenuThird.name }"
                                               href="javascript:void(0)">${listMenuThird.name }</a></li>
                                    </#list>
                            </#if>
                        </ul>
                    </li>
                </#list>
            </ul>
        </dd>-->
    </ul>
<#--</#list>-->
    </div>
</aside>
<div class="dislpayArrow hidden-xs">
    <a class="pngfix" href="javascript:void(0);"
       onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active"><span title="我的桌面" data-href="${ctx}/html/welcome.html">我的桌面</span><em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group">
            <a id="js-tabNav-prev" class="btn radius btn-default size-S"
               href="javascript:"><i class="Hui-iconfont">&#xe6d4;</i></a><a
                id="js-tabNav-next" class="btn radius btn-default size-S"
                href="javascript:"><i class="Hui-iconfont">&#xe6d7;</i></a>
        </div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src="${ctx}/html/welcome.html"></iframe>
        </div>
    </div>
</section>
<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前</li>
        <li id="closeall">关闭全部</li>
    </ul>
</div>
<script type="text/javascript"
        src="${ctx }/ui/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>

<script type="text/javascript">
    //sidebarMenu
    $.sidebarMenu = function (menu) {
        var animationSpeed = 300;
        $(menu).on('click', 'li a',
                function (e) {
                    var $this = $(this);
                    var checkElement = $this.next();
                    if (checkElement.is('.treeview-menu') && checkElement.is(':visible')) {
                        checkElement.slideUp(animationSpeed,
                                function () {
                                    checkElement.removeClass('menu-open');
                                });
                        checkElement.parent("li").removeClass("active");
                    }
                    //If the menu is not visible
                    else if ((checkElement.is('.treeview-menu')) && (!checkElement.is(':visible'))) {
                        //Get the parent menu
                        var parent = $this.parents('ul').first();
                        //Close all open menus within the parent
                        var ul = parent.find('ul:visible').slideUp(animationSpeed);
                        //Remove the menu-open class from the parent
                        ul.removeClass('menu-open');
                        //Get the parent li
                        var parent_li = $this.parent("li");

                        //Open the target menu and add the menu-open class
                        checkElement.slideDown(animationSpeed,
                                function () {
                                    //Add the class active to the parent li
                                    checkElement.addClass('menu-open');
                                    parent.find('li.active').removeClass('active');
                                    parent_li.addClass('active');
                                });
                    }
                    //if this isn't a link, prevent the page from being redirected
                    if (checkElement.is('.treeview-menu')) {
                        e.preventDefault();
                    }
                });
    }
    $.sidebarMenu($('.sidebar-menu'));

    function toUserInfo(userid) {
        layer.open({
            type: 2,
            area: ['750px', '400px'],
            fix: false, // 不固定
            maxmin: false,
            shade: 0.4,
            title: '个人信息',
            content: '${ctx}/user/toUserInfo?id=' + userid,
            end: function () {
            }
        });
    }

</script>
</body>
</html>
