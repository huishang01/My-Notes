str = "万过薪月，员序程马黑来，nohtyP学"

new_str = str[9 : 4 : -1]
print(new_str)

new_str2 = str[::-1][9:14]
print(new_str2)

new_str3 = str.split('，')[1].replace('来', '')[::-1]
print(new_str3)