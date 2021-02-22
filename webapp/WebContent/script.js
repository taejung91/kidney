var data = [
	{ 'tool': 'Phtoshop', 'skill': 35, 'color': 'blue'},
	{ 'tool': '12412', 'skill': 29, 'color': 'blue'},
	{ 'tool': '134', 'skill': 54, 'color': 'blue'},
	{ 'tool': '134', 'skill': 85, 'color': 'blue'},
	{ 'tool': '13445', 'skill': 15, 'color': 'blue'},
	
];

$('.graph li').each(function(){
	var color = data[index].color;
	$(this).children('h2').css('color', color).text(data[index].tool);
	
	var bar = $(this).children('strong');
	
	bar.css('background-color', color);
	bar.delay(10000*index).animate({'width':data[index].skill + '%'},{
		duration: 3000,
		step: function(now){
			$(this).text(Math.round(now) + '%');
		}
	});
	
});