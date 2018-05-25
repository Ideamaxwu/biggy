var data = [
  {month: "WordCount", Input: 10, Storage: 20, Control: 5, Computation: 30, Output: 10},
  {month: "Sort", Input: 10, Storage: 18, Control: 6, Computation: 40, Output: 10},
  {month: "K-means", Input:  8, Storage:  20, Control: 8, Computation: 50, Output: 8},
  {month: "PageRank", Input:  8, Storage:  24, Control: 10, Computation: 100, Output: 10}
];

var series = d3.stack()
    .keys(["Input", "Storage", "Control", "Computation", "Output"])
    .offset(d3.stackOffsetDiverging)
    (data);

var svg = d3.select("svg"),
    margin = {top: 20, right: 30, bottom: 30, left: 60},
    width = +svg.attr("width"),
    height = +svg.attr("height");

var x = d3.scaleBand()
    .domain(data.map(function(d) { return d.month; }))
    .rangeRound([margin.left, width - margin.right])
    .padding(0.1);

var y = d3.scaleLinear()
    .domain([d3.min(series, stackMin), d3.max(series, stackMax)])
    .rangeRound([height - margin.bottom, margin.top]);

var z = d3.scaleOrdinal(d3.schemeCategory10);

svg.append("g")
  .selectAll("g")
  .data(series)
  .enter().append("g")
    .attr("fill", function(d) { return z(d.key); })
  .selectAll("rect")
  .data(function(d) { return d; })
  .enter().append("rect")
    .attr("width", x.bandwidth)
    .attr("x", function(d) { return x(d.data.month); })
    .attr("y", function(d) { return y(d[1]); })
    .attr("height", function(d) { return y(d[0]) - y(d[1]); })

svg.append("g")
    .attr("transform", "translate(0," + y(0) + ")")
    .call(d3.axisBottom(x));

svg.append("g")
    .attr("transform", "translate(" + margin.left + ",0)")
    .call(d3.axisLeft(y));

function stackMin(serie) {
  return d3.min(serie, function(d) { return d[0]; });
}

function stackMax(serie) {
  return d3.max(serie, function(d) { return d[1]; });
}