// Generated, do not edit by hand
package org.whitehole.binary.pe;

import java.nio.ByteBuffer;

public class OptionalHeader {
	public OptionalHeader(ByteBuffer buffer, int start) {
		int offset = start;
		
		// Read standard fields
		_standardFields = new OptionalHeaderStandardFields(buffer, offset);
		offset += OptionalHeaderStandardFields.byteSize;
		
		// Read windows specific fields
		if (_standardFields.getMagic().is(MagicNumber.Valid.PE32)) {
			// Read PE fields
			_windowsSpecificFields = new OptionalHeaderPE32Fields(buffer, offset);
			offset += OptionalHeaderPE32Fields.byteSize;
		} else if (_standardFields.getMagic().is(MagicNumber.Valid.PE32x)) {
			// Read PE32+ fields
			_windowsSpecificFields = new OptionalHeaderPE32xFields(buffer, offset);
			offset += OptionalHeaderPE32xFields.byteSize;
		} else
			_windowsSpecificFields = null; // error?

		if (_windowsSpecificFields != null) {
			// Read data directories
			long dataDirectoryCount = _windowsSpecificFields.getRvaAndSizeCount().toBigInteger().longValue();

			_exportTable = (1 <= dataDirectoryCount) ? new DataDirectory(buffer, offset) : null;
			_importTable = (2 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + DataDirectory.byteSize) : null;
			_resourceTable = (3 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 2 * DataDirectory.byteSize) : null;
			_exceptionTable = (4 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 3 * DataDirectory.byteSize) : null;
			_certificateTable = (5 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 4 * DataDirectory.byteSize) : null;
			_baseRelocationTable = (6 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 5 * DataDirectory.byteSize) : null;
			_debug = (7 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 6 * DataDirectory.byteSize) : null;
			_architecture = (8 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 7 * DataDirectory.byteSize) : null;
			_globalPtr = (9 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 8 * DataDirectory.byteSize) : null;
			_TLSTable = (10 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 9 * DataDirectory.byteSize) : null;
			_loadConfigTable = (11 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 10 * DataDirectory.byteSize) : null;
			_boundImport = (12 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 11 * DataDirectory.byteSize) : null;
			_IAT = (13 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 12 * DataDirectory.byteSize) : null;
			_delayImportDescriptor = (14 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 13 * DataDirectory.byteSize) : null;
			_CLRRuntimeHeader = (15 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 14 * DataDirectory.byteSize) : null;
			_reserved = (16 <= dataDirectoryCount) ? new DataDirectory(buffer, offset + 15 * DataDirectory.byteSize) : null;
			offset += dataDirectoryCount * DataDirectory.byteSize;
			
			if (16 < dataDirectoryCount)
				; // error?
		}
		else {
			_exportTable = null;
			_importTable = null;
			_resourceTable = null;
			_exceptionTable = null;
			_certificateTable = null;
			_baseRelocationTable = null;
			_debug = null;
			_architecture = null;
			_globalPtr = null;
			_TLSTable = null;
			_loadConfigTable = null;
			_boundImport = null;
			_IAT = null;
			_delayImportDescriptor = null;
			_CLRRuntimeHeader = null;
			_reserved = null;
		}
		
		byteSize = offset - start;
	}

	public OptionalHeaderStandardFields getStandardFields() {
		return _standardFields;
	}

	public WindowsSpecificPEFields getWindowsSpecificFields() {
		return _windowsSpecificFields;
	}

	public DataDirectory getExportTable() {
		return _exportTable;
	}

	public DataDirectory getImportTable() {
		return _importTable;
	}

	public DataDirectory getResourceTable() {
		return _resourceTable;
	}

	public DataDirectory getExceptionTable() {
		return _exceptionTable;
	}

	public DataDirectory getCertificateTable() {
		return _certificateTable;
	}

	public DataDirectory getBaseRelocationTable() {
		return _baseRelocationTable;
	}

	public DataDirectory getDebug() {
		return _debug;
	}

	public DataDirectory getArchitecture() {
		return _architecture;
	}

	public DataDirectory getGlobalPtr() {
		return _globalPtr;
	}

	public DataDirectory getTLSTable() {
		return _TLSTable;
	}

	public DataDirectory getLoadConfigTable() {
		return _loadConfigTable;
	}

	public DataDirectory getBoundImport() {
		return _boundImport;
	}

	public DataDirectory getIAT() {
		return _IAT;
	}

	public DataDirectory getDelayImportDescriptor() {
		return _delayImportDescriptor;
	}

	public DataDirectory getCLRRuntimeHeader() {
		return _CLRRuntimeHeader;
	}

	public DataDirectory getReserved() {
		return _reserved;
	}
	
	public final int byteSize;

	private final OptionalHeaderStandardFields _standardFields;
	private final WindowsSpecificPEFields _windowsSpecificFields;
	private final DataDirectory _exportTable;
	private final DataDirectory _importTable;
	private final DataDirectory _resourceTable;
	private final DataDirectory _exceptionTable;
	private final DataDirectory _certificateTable;
	private final DataDirectory _baseRelocationTable;
	private final DataDirectory _debug;
	private final DataDirectory _architecture;
	private final DataDirectory _globalPtr;
	private final DataDirectory _TLSTable;
	private final DataDirectory _loadConfigTable;
	private final DataDirectory _boundImport;
	private final DataDirectory _IAT;
	private final DataDirectory _delayImportDescriptor;
	private final DataDirectory _CLRRuntimeHeader;
	private final DataDirectory _reserved;
}