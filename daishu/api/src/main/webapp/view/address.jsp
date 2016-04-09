<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="address_list" style="padding: 0;">
    <ul class="am-list">
        <li class="am-g am-list-item-dated list-item-address">
            <div class="am-u-sm-12">
                <div class="address-content-wrapper">
                    <label><input type="checkbox" style="display: none;"><img class="address-icon" src="static/img/selected.png">
                        <span class="address-content">高新区天府大道中段11号</span></label>
                </div>
            </div>
            <div class="am-u-sm-5 am-u-sm-offset-1">
                <label><img class="address-icon address-icon-small" src="static/img/localtion.png"><span class="address-loaction">成都</span></label>
            </div>
            <div class="am-u-sm-3">
                <a><img class="address-icon address-icon-small" src="static/img/edit.png"><span class="address-edit">编辑</span></a>
            </div>
            <div class="am-u-sm-3">
                <a><img class="address-icon address-icon-small" src="static/img/delete.png"><span class="address-delete">删除</span></a>
            </div>
        </li>
        <li class="am-g am-list-item-dated list-item-address">
            <div class="am-u-sm-12">
                <div class="address-content-wrapper">
                    <label><input type="checkbox" style="display: none;"><img class="address-icon" src="static/img/selected.png">
                        <span class="address-content">高新区天府大道中段11号</span></label>
                </div>
            </div>
            <div class="am-u-sm-5 am-u-sm-offset-1">
                <label><img class="address-icon address-icon-small" src="static/img/localtion.png"><span class="address-loaction">成都</span></label>
            </div>
            <div class="am-u-sm-3">
                <a><img class="address-icon address-icon-small" src="static/img/edit.png"><span class="address-edit">编辑</span></a>
            </div>
            <div class="am-u-sm-3">
                <a><img class="address-icon address-icon-small" src="static/img/delete.png"><span class="address-delete">删除</span></a>
            </div>
        </li>
    </ul>
    <button type="button" class="am-btn am-btn-default am-btn-block">添加新地址</button>
</div>
<div id="address_edit" style="padding: 0;display: none">
	<input type="hidden" name="id">
    <div class="am-g forminfo-container">
        <div class="am-u-sm-12 forminfo-wrapper">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">所在区域：</span>
                <input type="text" class="am-form-field" placeholder="请填写您所在省市区" required="required">
            </div>
        </div>
        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">街 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;道：</span>
                <input type="text" class="am-form-field" placeholder="请填写您所在街道" required>
            </div>
        </div>
        <div class="am-u-sm-12 forminfo-wrapper margin-top-1">
            <div class="am-input-group am-input-group-lg">
                <span class="am-input-group-label">详细地址：</span>
                <input type="text" class="am-form-field" placeholder="请填写您的详细地址" required>
            </div>
        </div>
    </div>
    <div class="am-g margin-top-2" style="padding: 0 2rem">
        <button type="button" class="am-btn am-btn-warning am-btn-block am-btn-lg am-radius">保存</button>
    </div>
</div>