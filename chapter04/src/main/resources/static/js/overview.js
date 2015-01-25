var NotesOverview = React.createClass({displayName: "NotesOverview",
  getInitialState: function() {
    return {data: []};
  },
  componentDidMount: function() {
    $.ajax({url: this.props.url, success: function(data) {
	  this.setState({data: data});
	}.bind(this)});
  },
  handleNoteSubmit: function(note) {
	  var notes = this.state.data;
	  var newNotes = notes.concat([note]);
	  this.setState({data: newNotes});
	  
	  $.ajax({ 
		 url: "/notes", 
		 type: 'POST', 
		 data: JSON.stringify(note), 
		 contentType: 'application/json'
	});
  },
  render: function() {
    return (
      React.createElement("div", null, 
      	React.createElement("h2", null, "Add new note"), 
        React.createElement(NotesForm, {onNoteSubmit: this.handleNoteSubmit}), 
        React.createElement("hr", null), 
        React.createElement("h2", null, "Notes"),
        React.createElement(NotesList, {data: this.state.data})
      )
    );
  }
});

var NotesForm = React.createClass({displayName: "NotesForm",
  handleSubmit: function(e) {
	e.preventDefault();  
	var text = this.refs.text.getDOMNode().value.trim();
	this.props.onNoteSubmit({"text": text});
    this.refs.text.getDOMNode().value = '';
  },
  render: function() {
    return (
    	React.createElement("form", {onSubmit: this.handleSubmit}, 
    		React.createElement("div", {className: "form-group"}, 
    			React.createElement("textarea", {className: "form-control", placeholder: "Type your note...", ref: "text"})
    		), 
    		React.createElement("button", {type: "submit", className: "btn btn-primary"}, "Submit")
    	)
    );
  }
});

var NotesList = React.createClass({displayName: "NotesList",
	render: function() {		  
		var notesNodes = this.props.data.map(function (note) {
	      return (React.createElement(Note, null, note.text));
	    });
	    return (React.createElement("div", null, notesNodes));
	}
});

var Note = React.createClass({displayName: "Note",
	render: function() {
	    return (React.createElement("div", null, this.props.children));
	}
});

React.render(React.createElement(NotesOverview, {url: "/notes"}), document.getElementById("content"));